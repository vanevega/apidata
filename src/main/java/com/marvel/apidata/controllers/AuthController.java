package com.marvel.apidata.controllers;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.marvel.apidata.auth.JWTUtil;
import com.marvel.apidata.models.ErrorResp;
import com.marvel.apidata.models.LoginReq;
import com.marvel.apidata.models.LoginRes;
import com.marvel.apidata.models.User;

@Controller
@RequestMapping("/outside")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JWTUtil jwtUtil;
    
    public AuthController(AuthenticationManager authenticationManager, JWTUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping("/")
    public ResponseEntity<String> helloAPI() {
        return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .header(HttpHeaders.CONTENT_TYPE, "application/json")
        .body("Hola desde el APIDATA");
    }
	
    @SuppressWarnings("rawtypes")
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(value = "/login")
    public ResponseEntity login(@RequestBody LoginReq loginReq)  {
        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginReq.getUsername(), loginReq.getPassword()));
            String username = authentication.getName();
            User user = new User(username);
            String token = jwtUtil.createToken(user);
            LoginRes loginRes = new LoginRes(username,token);
            return ResponseEntity.ok(loginRes);
        }catch (BadCredentialsException e){
            ErrorResp errorResponse = new ErrorResp(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }catch (AuthenticationException e){
            ErrorResp errorResponse = new ErrorResp(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }
}
package com.marvel.apidata.models;

public class User {

    private Long id;

    private String username;

    private String token;

    public User(String username) {
        this.username = username;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}


}
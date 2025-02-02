package com.marvel.apidata.models;

import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "access")
public class Access {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "access_type")
    private Integer accessType;

    @CreationTimestamp
    @Column(name = "access_at")
    private LocalDateTime accessAt;

    public Integer getId() {
        return id;
    }

    public Integer getAccessType() {
        return accessType;
    }

    public void setAccessType(Integer accessType) {
        this.accessType = accessType;
    }

    public LocalDateTime getAccessAt() {
        return accessAt;
    }

    public void setAccessAt(LocalDateTime accessAt) {
        this.accessAt = accessAt;
    }
}

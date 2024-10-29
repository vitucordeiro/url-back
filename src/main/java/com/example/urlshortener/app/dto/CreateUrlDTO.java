package com.example.urlshortener.app.dto;

import java.time.Instant;

import lombok.Data;

@Data
public class CreateUrlDTO {
    
    private String longUrl;
    private Instant created_At;

    public CreateUrlDTO(String longUrl){
        this.longUrl = longUrl;
        this.created_At = Instant.now();
    }
    
}

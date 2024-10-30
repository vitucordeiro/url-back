package com.example.urlshortener.app.dto;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UrlDTO {
    private String longUrl;
    private String shortUrl;
    private Instant created_At;
    private int countClick;

    public UrlDTO(String longUrl){
        this.longUrl = longUrl;
        this.shortUrl = "";
        this.created_At = Instant.now();
        this.countClick = 0;
    }
    

    
}

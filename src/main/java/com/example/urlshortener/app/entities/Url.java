package com.example.urlshortener.app.entities;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.urlshortener.app.dto.UrlDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "urls")
public class Url implements Serializable {
    private static final Long SerialVersionUID = 1L;
    
    @Id
    private String id;
    
    @NonNull
    private String longUrl;
    
    private String shortUrl;

    private Instant created_At;

    private int clickCount;

    public Url(String longUrl, Instant created_At){
        this.longUrl = longUrl;
        this.created_At = created_At;
        this.shortUrl = "";
        this.clickCount = 0;
    }
    public Url(UrlDTO createUrlDTO){
        this.longUrl = createUrlDTO.getLongUrl();
        this.created_At = createUrlDTO.getCreated_At();
        this.shortUrl = "";
        this.clickCount = 0;
    }
}

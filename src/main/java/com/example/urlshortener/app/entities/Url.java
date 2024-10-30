package com.example.urlshortener.app.entities;

import java.io.Serializable;
import java.time.Instant;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.urlshortener.app.dto.UrlDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document(collection = "urls")
@NoArgsConstructor
@AllArgsConstructor
public class Url implements Serializable {
    private static final Long SerialVersionUID = 1L;
    @Id
    private String id;
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

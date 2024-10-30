package com.example.urlshortener.app.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.urlshortener.app.entities.Url;


public interface UrlRepository extends MongoRepository<Url, String> {
    @Query( value = "{ 'shortUrl': ?0 }", fields = "{ 'longUrl': 1, '_id':0 }")
    Optional<Url> findByShortUrl(String shortUrl);
}

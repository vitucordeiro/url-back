package com.example.urlshortener.app.repository;


import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;

import com.example.urlshortener.app.entities.Url;


public interface UrlRepository extends MongoRepository<Url, String> {
    
    @Query( value = "{ 'shortUrl': ?0 }", fields = "{ 'longUrl': 1, '_id':0 }")
    Optional<Url> findByShortUrl(String shortUrl);

    @Query( value = "{'shortUrl': ?0 }", fields = "{ 'clickCount': 1, '_id':0 }")
    Optional<Url> findClickCountByShortUrl(String shortUrl);

    @Query(value = "{ 'shortUrl': ?0 }")
    @Update("{ '$inc': { 'clickCount':1}}")
    void incrementClickCount(String shortUrl);
}

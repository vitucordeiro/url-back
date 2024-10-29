package com.example.urlshortener.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.urlshortener.app.entities.Url;

public interface UrlRepository extends MongoRepository<Url, String >{

}

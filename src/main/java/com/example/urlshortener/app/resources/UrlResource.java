package com.example.urlshortener.app.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlshortener.app.dto.UrlDTO;



@RestController
@RequestMapping(value = "/v1/url")
public class UrlResource {
    @PostMapping("/create")
    public ResponseEntity<UrlDTO> createShortenerUrl(@RequestBody UrlDTO entity) {
        //TODO: process POST request
        
        return ResponseEntity.ok().body(entity);
        
        
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<String> getMethodName(@PathVariable String id) {

        return ResponseEntity.ok().body(id);
    }
    

    
}

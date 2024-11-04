package com.example.urlshortener.app.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.urlshortener.app.dto.UrlDTO;
import com.example.urlshortener.app.services.UrlService;
import com.example.urlshortener.app.services.exceptions.ResourceNotFoundException;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
@RequestMapping
public class UrlResource {

    @Autowired
    private UrlService service;

    @PostMapping("/create")
    public ResponseEntity<String> createShortenerUrl(@RequestBody UrlDTO urlDTO) {
        String urlShortener = service.createShortenerUrl(urlDTO);
        return ResponseEntity.ok().body(urlShortener);  
    }
    
    @GetMapping("/{shortUrl}")
    public ResponseEntity<Void> redirectToLongUrl(@PathVariable String shortUrl) {
        try {
            log.info("Recebida requisição para shortUrl: {}", shortUrl);
            
            String longUrl = service.getLongUrlAndIncreaseClick(shortUrl);
            
            log.info("Redirecionando para: {}", longUrl);
            return ResponseEntity
                .status(HttpStatus.FOUND)
                .location(URI.create(longUrl))
                .build();
                
        } catch (ResourceNotFoundException e) {
            log.error("URL não encontrada: {}", shortUrl);
            return ResponseEntity.notFound().build();
            
        } catch (Exception e) {
            log.error("Erro ao processar shortUrl: {}", shortUrl, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/status/{shortUrl}")
    public ResponseEntity<String> getStatus(@PathVariable String shortUrl) {
        try {
            log.info("Recebida requisição para shortUrl: {}", shortUrl);
            
            int clicks = service.getStatus(shortUrl);
            
            return ResponseEntity.ok().body(String.valueOf(clicks));
                
        } catch (ResourceNotFoundException e) {
            log.error("URL não encontrada: {}", shortUrl);
            return ResponseEntity.notFound().build();
            
        } catch (Exception e) {
            log.error("Erro ao processar shortUrl: {}", shortUrl, e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}

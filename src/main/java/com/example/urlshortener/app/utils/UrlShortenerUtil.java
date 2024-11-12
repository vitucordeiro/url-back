package com.example.urlshortener.app.utils;



import java.util.Random;

public class UrlShortenerUtil {

    public String[] letters = {
        "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
        "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
        "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
        "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
    };

    public UrlShortenerUtil(){}

    public String RandomStringFactory(int lengthResult ){
        int lengthLetters = letters.length;
        String[] newString;
        newString = new String[lengthResult];
        for(var i = 0; i < lengthResult; i++) {
            int randomIndex = new Random().nextInt(lengthLetters);
            newString[i] = letters[randomIndex];
        }
        
        StringBuilder result = new StringBuilder();
        for(String s : newString) {
            result.append(s);
        }
        return result.toString();
    }
}

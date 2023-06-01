package com.codals.greating.util;

import java.util.UUID;

public class ImageUrlGenerator {
	
    public static String generateUniqueUrl() {
    	UUID uuid = UUID.randomUUID();    
        return uuid.toString();
        }
}
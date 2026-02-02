package com.pichincha.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pichincha.models.User;

import java.io.File;

public class JsonUtils {
    public static User readJson(String path) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(path), User.class);
        } catch (Exception e) {
            throw new RuntimeException("Error leyendo archivo JSON", e);
        }
    }
}


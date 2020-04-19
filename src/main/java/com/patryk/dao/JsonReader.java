package com.patryk.dao;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.patryk.model.User;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.File;
import java.io.IOException;
import java.util.*;

@Repository
public class JsonReader implements DataReader {
    public List<User> ReadData(String fileName) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            File file = new ClassPathResource(fileName).getFile();

            JsonNode rootNode = objectMapper.readTree(file);
            JsonNode nameNode = rootNode.path("employees");
            Iterator nodeIterator = nameNode.elements();
            List<User> users = new ArrayList<>();
            nodeIterator.forEachRemaining(x -> {
                try {
                    users.add(objectMapper.readValue(x.toString(), User.class));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            return users;
        }catch (Exception e){
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}

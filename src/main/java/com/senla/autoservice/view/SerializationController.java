package com.senla.autoservice.view;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SerializationController {
    public static class SerializationControllerSingl{
        public static final SerializationController INSTANCE = new SerializationController();
    }

    private ObjectMapper objectMapper;

    public static SerializationController getInstance() {
        return SerializationControllerSingl.INSTANCE;
    }

    private SerializationController() {
        objectMapper = new ObjectMapper();
        objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
    }

    public <T> void writeObject(List<T> object, String fileName) {
        try {
            objectMapper.writeValue(new File("src/" + fileName + ".json"), object);

        } catch (Exception msg) {
            System.out.println(msg.getMessage());
        }
    }

    public <T> ArrayList<T> readObject(Class arrayType, String fileName) throws IOException {
        try {
            CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, arrayType);
            List<T> list = objectMapper.readValue(new File("src/" + fileName + ".json"), collectionType);
            return (ArrayList<T>) list;
        } catch (Exception msg) {
            System.out.println(msg.getMessage());
            throw msg;
        }
    }
}

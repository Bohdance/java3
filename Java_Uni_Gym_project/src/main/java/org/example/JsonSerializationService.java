package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class JsonSerializationService<T> implements SerializationService<T> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void serialize(T obj, String filePath) throws IOException {
        objectMapper.writeValue(new File(filePath), obj);
    }

    // Десеріалізація за Class<T>
    @Override
    public T deserialize(String filePath, Class<T> clazz) throws IOException {
        return objectMapper.readValue(new File(filePath), clazz);
    }

    // Десеріалізація за TypeReference<T>
    @Override
    public T deserialize(String filePath, TypeReference<T> typeReference) throws IOException {
        return objectMapper.readValue(new File(filePath), typeReference);
    }
}

package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;

public interface SerializationService<T> {
    void serialize(T obj, String filePath) throws IOException;

    // Метод десеріалізації на основі Class<T>
    T deserialize(String filePath, Class<T> clazz) throws IOException;

    // Метод десеріалізації на основі TypeReference<T>
    T deserialize(String filePath, TypeReference<T> typeReference) throws IOException;
}

package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.File;
import java.io.IOException;

public class XmlSerializationService<T> implements SerializationService<T> {
    private final XmlMapper xmlMapper = new XmlMapper();

    @Override
    public void serialize(T obj, String filePath) throws IOException {
        xmlMapper.writeValue(new File(filePath), obj);
    }

    // Десеріалізація за Class<T>
    @Override
    public T deserialize(String filePath, Class<T> clazz) throws IOException {
        return xmlMapper.readValue(new File(filePath), clazz);
    }

    // Десеріалізація за TypeReference<T>
    @Override
    public T deserialize(String filePath, TypeReference<T> typeReference) throws IOException {
        return xmlMapper.readValue(new File(filePath), typeReference);
    }
}


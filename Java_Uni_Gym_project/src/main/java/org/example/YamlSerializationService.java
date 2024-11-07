package org.example;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.io.File;
import java.io.IOException;

public class YamlSerializationService<T> implements SerializationService<T> {
    private final YAMLMapper yamlMapper = new YAMLMapper();

    @Override
    public void serialize(T obj, String filePath) throws IOException {
        yamlMapper.writeValue(new File(filePath), obj);
    }

    // Десеріалізація за Class<T>
    @Override
    public T deserialize(String filePath, Class<T> clazz) throws IOException {
        return yamlMapper.readValue(new File(filePath), clazz);
    }

    // Десеріалізація за TypeReference<T>
    @Override
    public T deserialize(String filePath, TypeReference<T> typeReference) throws IOException {
        return yamlMapper.readValue(new File(filePath), typeReference);
    }
}

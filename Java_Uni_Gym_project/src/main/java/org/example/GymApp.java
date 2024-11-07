package org.example;

import com.fasterxml.jackson.core.type.TypeReference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class GymApp {
    public static void main(String[] args) throws IOException {
        Gym gym = new Gym(1, "123 Fitness St.", "Mon-Sun 6am-10pm");
        Trainer trainer1 = new Trainer(1, "John Doe", "123 Main St", "123-456-7890", "M-F 8am-5pm", "Weightlifting", gym);
        Trainer trainer2 = new Trainer(2, "Jane Smith", "456 Elm St", "987-654-3210", "M-F 8am-5pm", "Cardio", gym);

        List<Client> clients = new ArrayList<>();
        clients.add(new Client.ClientBuilder()
                .setClientId(1)
                .setClientName("Alice")
                .setAddress("789 Pine St")
                .setContactInfo("555-1234")
                .setMembershipDetails("Gold")
                .setAssignedTrainer(trainer1)
                .build());
        clients.add(new Client.ClientBuilder()
                .setClientId(2)
                .setClientName("Bob")
                .setAddress("159 Oak St")
                .setContactInfo("555-5678")
                .setMembershipDetails("Silver")
                .setAssignedTrainer(trainer2)
                .build());
        clients.add(new Client.ClientBuilder()
                .setClientId(3)
                .setClientName("Charlie")
                .setAddress("753 Maple St")
                .setContactInfo("555-8765")
                .setMembershipDetails("Platinum")
                .setAssignedTrainer(trainer1)
                .build());

        ClientService clientService = new ClientService();

        // Сортування клієнтів за ім'ям
        System.out.println("Sorted Clients:");
        List<Client> sortedClients = clientService.getSortedClientsByName(clients);
        sortedClients.forEach(System.out::println);

        // Отримання клієнтів за спеціалізацією тренера
        System.out.println("\nClients with Cardio specialization:");
        List<Client> cardioClients = clientService.getClientsWithTrainerSpecialization(clients, "Cardio");
        cardioClients.forEach(System.out::println);

        // Отримання клієнтів, які мають одного й того ж тренера
        System.out.println("\nClients with trainer John Doe:");
        List<Client> johnClients = clientService.getClientsByTrainer(clients, trainer1);
        johnClients.forEach(System.out::println);

        // Серіалізація клієнтів у JSON формат
        JsonSerializationService<List<Client>> jsonService = new JsonSerializationService<>();
        String jsonFilePath = "clients.json";
        jsonService.serialize(clients, jsonFilePath);
        System.out.println("\nClients have been serialized to JSON.");

        // Десеріалізація клієнтів з JSON файлу
        List<Client> deserializedJsonClients = jsonService.deserialize(jsonFilePath, new TypeReference<List<Client>>() {});
        System.out.println("Clients deserialized from JSON:");
        deserializedJsonClients.forEach(System.out::println);

        // Серіалізація клієнтів у XML формат
        XmlSerializationService<List<Client>> xmlService = new XmlSerializationService<>();
        String xmlFilePath = "clients.xml";
        xmlService.serialize(clients, xmlFilePath);
        System.out.println("\nClients have been serialized to XML.");

        // Десеріалізація клієнтів з XML файлу
        List<Client> deserializedXmlClients = xmlService.deserialize(xmlFilePath, new TypeReference<List<Client>>() {});
        System.out.println("Clients deserialized from XML:");
        deserializedXmlClients.forEach(System.out::println);

        // Серіалізація клієнтів у YAML формат
        YamlSerializationService<List<Client>> yamlService = new YamlSerializationService<>();
        String yamlFilePath = "clients.yaml";
        yamlService.serialize(clients, yamlFilePath);
        System.out.println("\nClients have been serialized to YAML.");

        // Десеріалізація клієнтів з YAML файлу
        List<Client> deserializedYamlClients = yamlService.deserialize(yamlFilePath, new TypeReference<List<Client>>() {});
        System.out.println("Clients deserialized from YAML:");
        deserializedYamlClients.forEach(System.out::println);
    }
}

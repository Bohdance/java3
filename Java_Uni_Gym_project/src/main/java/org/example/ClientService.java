package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class ClientService {

    /**
     * Сортування клієнтів за ім'ям, використовуючи Comparable.
     */
    public List<Client> getSortedClientsByName(List<Client> clients) {
        return clients.stream()
                .sorted() // Використовує метод compareTo з інтерфейсу Comparable
                .collect(Collectors.toList());
    }

    /**
     * Отримання клієнтів за спеціалізацією тренера, використовуючи Stream API.
     */
    public List<Client> getClientsWithTrainerSpecialization(List<Client> clients, String specialization) {
        return clients.stream()
                .filter(client -> client.getAssignedTrainer().getSpecialization().equals(specialization))
                .collect(Collectors.toList());
    }

    /**
     * Отримання клієнтів, які мають одного й того ж тренера, використовуючи Stream API.
     */
    public List<Client> getClientsByTrainer(List<Client> clients, Trainer trainer) {
        return clients.stream()
                .filter(client -> client.getAssignedTrainer().equals(trainer))
                .collect(Collectors.toList());
    }
}

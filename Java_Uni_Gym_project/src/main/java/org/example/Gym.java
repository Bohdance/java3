package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Objects;

public class Gym {
    private int gymId;
    private String address;
    private String schedule;

    // Конструктор за замовчуванням
    public Gym() {}

    // Конструктор з параметрами
    @JsonCreator
    public Gym(@JsonProperty("gymId") int gymId,
               @JsonProperty("address") String address,
               @JsonProperty("schedule") String schedule) {
        this.gymId = gymId;
        this.address = address;
        this.schedule = schedule;
    }

    // Getters
    public int getGymId() {
        return gymId;
    }

    public String getAddress() {
        return address;
    }

    public String getSchedule() {
        return schedule;
    }

    @Override
    public String toString() {
        return "Gym{" +
               "gymId=" + gymId +
               ", address='" + address + '\'' +
               ", schedule='" + schedule + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Gym gym = (Gym) obj;
        return gymId == gym.gymId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(gymId);
    }
}

package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;
import java.util.Comparator;

public class Trainer {
    private int trainerId;
    private String trainerName;
    private String address;
    private String contactInfo;
    private String trainingSchedule;
    private String specialization;
    private Gym gym;

    // Конструктор за замовчуванням
    public Trainer() {}

    // Конструктор з параметрами
    @JsonCreator
    public Trainer(@JsonProperty("trainerId") int trainerId,
                   @JsonProperty("trainerName") String trainerName,
                   @JsonProperty("address") String address,
                   @JsonProperty("contactInfo") String contactInfo,
                   @JsonProperty("trainingSchedule") String trainingSchedule,
                   @JsonProperty("specialization") String specialization,
                   @JsonProperty("gym") Gym gym) {
        this.trainerId = trainerId;
        this.trainerName = trainerName;
        this.address = address;
        this.contactInfo = contactInfo;
        this.trainingSchedule = trainingSchedule;
        this.specialization = specialization;
        this.gym = gym;
    }

    // Getters
    public int getTrainerId() {
        return trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getTrainingSchedule() {
        return trainingSchedule;
    }

    public String getSpecialization() {
        return specialization;
    }

    public Gym getGym() {
        return gym;
    }

    // Setters (додано, якщо необхідно)
    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public void setTrainingSchedule(String trainingSchedule) {
        this.trainingSchedule = trainingSchedule;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    @Override
    public String toString() {
        return "Trainer{" +
               "trainerId=" + trainerId +
               ", trainerName='" + trainerName + '\'' +
               ", address='" + address + '\'' +
               ", contactInfo='" + contactInfo + '\'' +
               ", trainingSchedule='" + trainingSchedule + '\'' +
               ", specialization='" + specialization + '\'' +
               ", gym=" + gym +
               '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Trainer trainer = (Trainer) obj;
        return trainerId == trainer.trainerId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(trainerId);
    }

    /**
     * Компаратор для порівняння тренерів за спеціалізацією.
     */
    public static class TrainerSpecializationComparator implements Comparator<Trainer> {
        @Override
        public int compare(Trainer t1, Trainer t2) {
            return t1.getSpecialization().compareTo(t2.getSpecialization());
        }
    }
}

package org.example;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

@JsonIgnoreProperties(ignoreUnknown = true) // To ignore any unexpected JSON properties
public class Client implements Comparable<Client> {
    private final int clientId;
    private final String clientName;
    private final String address;
    private final String contactInfo;
    private final String membershipDetails;
    private final Trainer assignedTrainer;

    // Default constructor for Jackson
    public Client() {
        this.clientId = 0; // Set default value
        this.clientName = "";
        this.address = "";
        this.contactInfo = "";
        this.membershipDetails = "";
        this.assignedTrainer = null; // Set default value
    }

    // Constructor using builder
    private Client(ClientBuilder builder) {
        this.clientId = builder.clientId;
        this.clientName = builder.clientName;
        this.address = builder.address;
        this.contactInfo = builder.contactInfo;
        this.membershipDetails = builder.membershipDetails;
        this.assignedTrainer = builder.assignedTrainer;
    }

    // Getters
    public int getClientId() {
        return clientId;
    }

    public String getClientName() {
        return clientName;
    }

    public String getAddress() {
        return address;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getMembershipDetails() {
        return membershipDetails;
    }

    public Trainer getAssignedTrainer() {
        return assignedTrainer;
    }

    @Override
    public String toString() {
        return "Client{" +
                "clientId=" + clientId +
                ", clientName='" + clientName + '\'' +
                ", address='" + address + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", membershipDetails='" + membershipDetails + '\'' +
                ", assignedTrainer=" + assignedTrainer +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Client client = (Client) obj;
        return clientId == client.clientId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId);
    }

    /**
     * Порівняння клієнтів за ім'ям.
     */
    @Override
    public int compareTo(Client other) {
        return this.clientName.compareTo(other.clientName);
    }

    // Builder class
    public static class ClientBuilder {
        private int clientId;
        private String clientName;
        private String address;
        private String contactInfo;
        private String membershipDetails;
        private Trainer assignedTrainer;
        private final List<String> validationErrors = new ArrayList<>();

        public ClientBuilder setClientId(int clientId) {
            if (clientId <= 0) {
                validationErrors.add("clientId: " + clientId + " (ID має бути більше 0)");
            }
            this.clientId = clientId;
            return this;
        }

        public ClientBuilder setClientName(String clientName) {
            if (clientName == null || clientName.trim().isEmpty()) {
                validationErrors.add("clientName: " + clientName + " (Ім'я не може бути порожнім)");
            } else if (!Pattern.matches("^[A-Za-z ]+$", clientName)) {
                validationErrors.add("clientName: " + clientName + " (Ім'я має містити тільки літери)");
            }
            this.clientName = clientName;
            return this;
        }

        public ClientBuilder setAddress(String address) {
            if (address == null || address.trim().isEmpty()) {
                validationErrors.add("address: " + address + " (Адреса не може бути порожньою)");
            }
            this.address = address;
            return this;
        }

        public ClientBuilder setContactInfo(String contactInfo) {
            if (contactInfo == null || contactInfo.trim().isEmpty()) {
                validationErrors.add("contactInfo: " + contactInfo + " (Контактна інформація не може бути порожньою)");
            } else if (!Pattern.matches("^\\d{3}-\\d{3}-\\d{4}$", contactInfo)) {
                validationErrors.add("contactInfo: " + contactInfo + " (Контактна інформація повинна бути у форматі 123-456-7890)");
            }
            this.contactInfo = contactInfo;
            return this;
        }

        public ClientBuilder setMembershipDetails(String membershipDetails) {
            if (membershipDetails == null || membershipDetails.trim().isEmpty()) {
                validationErrors.add("membershipDetails: " + membershipDetails + " (Деталі членства не можуть бути порожніми)");
            }
            this.membershipDetails = membershipDetails;
            return this;
        }

        public ClientBuilder setAssignedTrainer(Trainer assignedTrainer) {
            if (assignedTrainer == null) {
                validationErrors.add("assignedTrainer: null (Тренер не може бути null)");
            }
            this.assignedTrainer = assignedTrainer;
            return this;
        }

        public Client build() {
            if (!validationErrors.isEmpty()) {
                throw new IllegalArgumentException("Помилки валідації: " + String.join(", ", validationErrors));
            }
            return new Client(this);
        }
    }
}

package com.ds.cvbank.model;

/**
 * @author Dogukan Sonmez
 */


public class Candidate {

    private Long id;

    private String firstName;

    private String lastName;

    private String address;

    private String email;

    private String phoneNumber;

    private String resume;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name : ").append(firstName).append(" ").append(lastName)
                .append(" Phone Number : ").append(phoneNumber)
                .append(" Email : ").append(email);
        return sb.toString();
    }
}

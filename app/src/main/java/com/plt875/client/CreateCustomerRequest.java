package com.plt875.client;

public class CreateCustomerRequest {

    private String title;

    private String firstName;

    private String lastName;

    public CreateCustomerRequest(String title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

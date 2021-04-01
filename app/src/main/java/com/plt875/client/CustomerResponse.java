package com.plt875.client;

public class CustomerResponse {

    private String id;

    private String title;

    private String firstName;

    private String lastName;

    public CustomerResponse(String id, String title, String firstName, String lastName) {
        this.id = id;
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getId() {
        return id;
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

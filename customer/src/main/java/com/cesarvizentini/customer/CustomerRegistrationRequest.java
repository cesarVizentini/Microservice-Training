package com.cesarvizentini.customer;

public record CustomerRegistrationRequest(String firstName,
                                          String lastName,
                                          String email) {

}

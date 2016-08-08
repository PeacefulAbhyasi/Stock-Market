package com.stockmarket.services;

import com.stockmarket.models.Person;

public interface PersonService {
    void addPerson(Person person);
    boolean checkPersonExist(String userName);
    boolean checkPassword(String userName, String password);
    Person findPerson(String userName);
}

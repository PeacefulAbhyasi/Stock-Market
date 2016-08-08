package com.stockmarket.dao;


import com.stockmarket.models.Person;

public interface PersonDao {
    void addPerson(Person person);
    boolean checkPersonExist(String userName);
    boolean checkPassword(String userName,String password);
    Person findPerson(String userName);
}

package com.stockmarket.services;

import com.stockmarket.dao.PersonDao;
import com.stockmarket.models.Person;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Transactional
    public void addPerson(Person person) {
        this.personDao.addPerson(person);
    }

    @Transactional
    public boolean checkPersonExist(String userName){
        return this.personDao.checkPersonExist(userName);
    }
    @Transactional
    public boolean checkPassword(String userName, String password) {
        return this.personDao.checkPassword(userName,password);
    }
    @Transactional
    public Person findPerson(String userName) {
        return this.personDao.findPerson(userName);
    }
}

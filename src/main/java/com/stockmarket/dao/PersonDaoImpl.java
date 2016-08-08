package com.stockmarket.dao;

import com.stockmarket.models.Person;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addPerson(Person person) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(person);
        System.out.println(person.toString() + " Added !");
    }
    public boolean checkPersonExist(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Person where userName='"+userName+"'");
        List<Person> persons = query.list();
        if(persons.size() != 0){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean checkPassword(String userName, String password) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("select password from Person where userName='"+userName+"'");
        List<String> passwords = query.list();
        if(password.equals(passwords.get(0))){
            return true;
        }
        else{
            return false;
        }
    }
    public Person findPerson(String userName) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Person where userName='"+userName+"'");
        List<Person> persons = query.list();
        return persons.get(0);
    }
}

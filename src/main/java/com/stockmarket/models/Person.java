package com.stockmarket.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PERSON", uniqueConstraints = {
    @UniqueConstraint(columnNames = "USER_NAME") })
public class Person implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PERSON_ID", unique = true , nullable = false)
    private Integer personId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;

    public Person() {
    }
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)

    @JoinTable(name = "PERSON_COMPANY_STOCK",
            joinColumns = {@JoinColumn(name = "PERSON_ID", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "COMPANY_ID", nullable = false, updatable = false)})
    private List<CompanyStock> companyStocks;

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CompanyStock> getCompanyStocks() {
        return companyStocks;
    }

    public void setCompanyStocks(List<CompanyStock> companyStocks) {
        this.companyStocks = companyStocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (!getPersonId().equals(person.getPersonId())) return false;
        if (!getFirstName().equals(person.getFirstName())) return false;
        if (!getLastName().equals(person.getLastName())) return false;
        if (!getUserName().equals(person.getUserName())) return false;
        if (!getPassword().equals(person.getPassword())) return false;
        return getCompanyStocks().equals(person.getCompanyStocks());

    }

    @Override
    public int hashCode() {
        int result = getPersonId().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getUserName().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + getCompanyStocks().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personId=" + personId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", companyStocks=" + companyStocks +
                '}';
    }
}

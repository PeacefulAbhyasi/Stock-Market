package com.stockmarket.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "COMPANY_STOCK" ,  uniqueConstraints = {
        @UniqueConstraint(columnNames = "COMPANY_NAME")})
public class CompanyStock implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COMPANY_ID", unique = true , nullable = false)
    private Integer companyId;
    @Column(name = "COMPANY_NAME")
    private String companyName;
    @Column(name = "STOCK_VALUE")
    private Double stockValue;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "companyStocks")
    private List<Person> persons ;


    public CompanyStock() {
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Double getStockValue() {
        return stockValue;
    }

    public void setStockValue(Double stockValue) {
        this.stockValue = stockValue;
    }

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}

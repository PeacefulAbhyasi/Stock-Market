package com.stockmarket.dao;

import com.stockmarket.models.CompanyStock;
import com.stockmarket.models.Person;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Repository
public class CompanyStockDaoImpl implements CompanyStockDao {
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void addCompanyStock(CompanyStock companyStock) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(companyStock);
        System.out.println("Company Stock " + companyStock.toString() + " Added !");
    }

    public void changeCompanyStock(CompanyStock companyStock) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("update CompanyStock set stockValue = '" + companyStock.getStockValue() + "' where companyName = '" + companyStock.getCompanyName() + "'");
        query.executeUpdate();
        System.out.println("Company Stock " + companyStock.toString() + "Updated !");
    }

    public List<CompanyStock> listCompanyStock() {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CompanyStock ");
        List<CompanyStock> companyStocks = query.list();
        return companyStocks;
    }

    public List<CompanyStock> listSubscriptions(Integer personId) {
        Session  session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Person where personId = " + personId);
        List<Person> persons = query.list();
        return persons.get(0).getCompanyStocks();
    }

    public List<CompanyStock> listNonSubscriptions(Integer personId) {
        Session session  = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from CompanyStock ");
        List<CompanyStock> allCompanyStocks  = query.list();
        query = session.createQuery("from Person where personId = " + personId);
        List<Person> temp = query.list();
        List<CompanyStock> subscriptions = temp.get(0).getCompanyStocks();
        HashSet<Integer> companyStockHashSet = new HashSet<Integer>();
        List<CompanyStock> companyStocks = new ArrayList<CompanyStock>();
        for (int i = 0; i < subscriptions.size(); i++) {
            companyStockHashSet.add(subscriptions.get(i).getCompanyId());
        }
        for (int i = 0; i < allCompanyStocks.size(); i++) {
            if(!companyStockHashSet.contains(allCompanyStocks.get(i).getCompanyId())){
                companyStocks.add(allCompanyStocks.get(i));
            }
        }
        System.out.println(companyStocks.size());
        return companyStocks;
    }

    public void addSubscription(Long companyId, Long personId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Person where personId = " + personId);
        List<Person> persons =  query.list();
        query = session.createQuery("from CompanyStock where companyId = " + companyId);
        List<CompanyStock> companyStock  = query.list();
        persons.get(0).getCompanyStocks().add(companyStock.get(0));
        return;
    }
}

package com.pisarev.nikolai.rest.dao;

import com.pisarev.nikolai.rest.entity.CallDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CallDetailDAOImpl implements CallDetailsDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCallDetails(CallDetails call) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(call);
    }

    @Override
    public List<CallDetails> getCallsForNumber(String phoneNumber) {
        Session session = sessionFactory.getCurrentSession();
        Query<CallDetails> query = session.createQuery("from CallDetails where phoneNumber = :phoneNumber", CallDetails.class);
        query.setParameter("phoneNumber", phoneNumber);

        List<CallDetails> calls = query.getResultList();

        return calls;
    }

    @Override
    public List<CallDetails> getCallsForDuration(int duration) {

        Session session = sessionFactory.getCurrentSession();
        Query<CallDetails> query = session.createQuery("from CallDetails where duration > :duration", CallDetails.class);
        query.setParameter("duration", duration);

        List<CallDetails> calls = query.getResultList();

        return calls;
    }

    @Override
    public void updateOldNumber(String oldPhoneNumber, String newPhoneNumber) {
        Session session = sessionFactory.getCurrentSession();
        Query<CallDetails> query = session.createQuery("update CallDetails set phoneNumber = :newPhoneNumber where phoneNumber = :oldPhoneNumber");

        query.setParameter("oldPhoneNumber", oldPhoneNumber);
        query.setParameter("newPhoneNumber", newPhoneNumber);
    }
}

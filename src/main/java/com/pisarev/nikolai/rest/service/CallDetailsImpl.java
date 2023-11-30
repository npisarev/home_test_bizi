package com.pisarev.nikolai.rest.service;

import com.pisarev.nikolai.rest.dao.CallDetailsDao;
import com.pisarev.nikolai.rest.entity.CallDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CallDetailsImpl implements CallDetailsService {

    @Autowired
    private CallDetailsDao callDetailsDao;

    @Override
    @Transactional
    public void saveCallDetails(CallDetails call) {
        callDetailsDao.saveCallDetails(call);

    }

    @Override
    @Transactional
    public List<CallDetails> getCallsForNumber(String phoneNumber) {


        return callDetailsDao.getCallsForNumber(phoneNumber);
    }

    @Override
    @Transactional
    public List<CallDetails> getCallsForDuration(int duration) {

        return callDetailsDao.getCallsForDuration(duration);
    }


    @Override
    @Transactional
    public void updateOldNumber(String oldPhoneNumber, String newPhoneNumber) {
        callDetailsDao.updateOldNumber(oldPhoneNumber,newPhoneNumber);

    }
}

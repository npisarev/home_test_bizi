package com.pisarev.nikolai.rest.service;

import com.pisarev.nikolai.rest.entity.CallDetails;

import javax.transaction.Transactional;
import java.util.List;



public interface CallDetailsService {

    public void saveCallDetails(CallDetails call);

    public List<CallDetails> getCallsForNumber(String phoneNumber);


    public List<CallDetails> getCallsForDuration(int duration);



    void updateOldNumber(String oldPhoneNumber, String newPhoneNumber);
}

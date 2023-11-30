package com.pisarev.nikolai.rest.dao;

import com.pisarev.nikolai.rest.entity.CallDetails;

import java.util.List;


public interface CallDetailsDao {

    public void saveCallDetails(CallDetails call) ;

    public List<CallDetails> getCallsForNumber(String phoneNumber);


    public List<CallDetails> getCallsForDuration(int duration);


    public void updateOldNumber(String oldPhoneNumber, String newPhoneNumber);


}

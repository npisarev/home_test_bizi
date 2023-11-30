package com.pisarev.nikolai.rest.checkcontol;

import com.pisarev.nikolai.rest.entity.CallDetails;
import com.pisarev.nikolai.rest.exception_handling.BlackListException;

import java.io.IOException;
import java.text.ParseException;


public interface FileCheckService {

    ;

    public String timeToSQLType(String time) throws ParseException;

    boolean blackListCheck(CallDetails call) throws BlackListException, IOException;

    boolean contactListCheck(CallDetails call) throws IOException;
}

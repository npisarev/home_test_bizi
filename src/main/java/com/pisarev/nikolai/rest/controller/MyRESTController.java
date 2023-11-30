package com.pisarev.nikolai.rest.controller;


import com.pisarev.nikolai.rest.checkcontol.FileCheckService;
import com.pisarev.nikolai.rest.entity.CallDetails;
import com.pisarev.nikolai.rest.exception_handling.BlackListException;
import com.pisarev.nikolai.rest.exception_handling.IncorectCallInfo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.pisarev.nikolai.rest.service.CallDetailsService;


import java.io.IOException;
import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {



    @Autowired
   private CallDetailsService callDetailsService;

    @Autowired
    private FileCheckService fileCheckService;



    @GetMapping("/callDetailsNumber/{phoneNumber}")
    public List<CallDetails> showCallDetailForNumber(@PathVariable String phoneNumber){
        List<CallDetails> details = callDetailsService.getCallsForNumber(phoneNumber);
        return details;

    }

    @GetMapping("/callDetailsduration/{duration}")
    public List<CallDetails> showCallDetailForduration(@PathVariable int duration){
        List<CallDetails> details = callDetailsService.getCallsForDuration(duration);
        return details;

    }
    @PostMapping("/saveCallDetails")
    public CallDetails saveCallDetails(@RequestBody CallDetails call) throws BlackListException, IOException, ParseException {
        if (fileCheckService.blackListCheck(call)){
            throw new BlackListException("The man with phone number: " + call.getPhoneNumber()+ " in the black list");
        };
        call.setSaveContact(fileCheckService.contactListCheck(call));
        call.setTime(fileCheckService.timeToSQLType(call.getTime()));
        callDetailsService.saveCallDetails(call);
        return call;
    }

    @PutMapping("/updateOldNumber")
    public void updateOldNumber(@RequestBody String oldNumber, String newNumber){
        callDetailsService.updateOldNumber(oldNumber,newNumber);
    }

    @ExceptionHandler
    public ResponseEntity<IncorectCallInfo> handleException(BlackListException exception){
        IncorectCallInfo info = new IncorectCallInfo();
        info.setInfo(exception.getMessage());
        return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
    }



}

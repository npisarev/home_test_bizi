package com.pisarev.nikolai.rest.checkcontol;

import com.pisarev.nikolai.rest.entity.CallDetails;
import com.pisarev.nikolai.rest.exception_handling.BlackListException;
import org.springframework.stereotype.Service;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class FileCheckImpl implements FileCheckService{



    @Override
    public String timeToSQLType(String time) throws ParseException {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        LocalDateTime dateTime = LocalDateTime.parse(time, inputFormatter);

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return dateTime.format(outputFormatter);
    }




    @Override
    public boolean blackListCheck(CallDetails call) throws BlackListException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\79211\\Downloads\\temp3\\temp\\blackList.csv")); {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                for (String value : values) {
                    if (value.equals(call.getPhoneNumber())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    @Override
    public boolean contactListCheck(CallDetails call) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\79211\\Downloads\\temp3\\temp\\contactList.csv")); {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");

                for (String value : values) {
                    if (value.equals(call.getPhoneNumber())) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}

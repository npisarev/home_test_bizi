package com.pisarev.nikolai.rest.entity;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "calldetails")
public class CallDetails {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "time")
    String  time;
    @Column(name = "callType")
    private String callType;
    @Column(name = "duration")
    private int duration;
    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "saveContact")
    private boolean saveContact;


    public CallDetails(){}

    public CallDetails(String time, String callType, int duration, String phoneNumber, boolean saveContact) {
        this.time = time;
        this.callType = callType;
        this.duration = duration;
        this.phoneNumber = phoneNumber;
        this.saveContact = saveContact;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCallType() {
        return callType;
    }

    public void setCallType(String callType) {
        this.callType = callType;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean isSaveContact() {
        return saveContact;
    }

    public void setSaveContact(boolean saveContact) {
        this.saveContact = saveContact;
    }

    @Override
    public String toString() {
        return "CallDetails{" +
                ", time=" + time +
                ", callType='" + callType +
                ", duration=" + duration +
                ", phoneNumber=" + phoneNumber +
                ", saveContact=" + saveContact +
                '}';
    }
}

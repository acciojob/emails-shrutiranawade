package com.driver;

import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;


public class Gmail extends Email {
    public class Mail {
        //date (Date), sender (String), message (String)
        private Date date;
        private String sender;
        private String message;

        public Mail(Date date, String sender, String message) {
            this.date = date;
            this.sender = sender;
            this.message = message;
        }

        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        public String getSender() {
            return sender;
        }

        public void setSender(String sender) {
            this.sender = sender;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    ArrayList<Triple<Date,String,String>> inbox;
    ArrayList<Triple<Date,String,String>> trash;
    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
       super(emailId);
      this.inboxCapacity = inboxCapacity;
      inbox = new ArrayList<>();
      trash = new ArrayList<>();
    }
    public void setInboxCapacity(int inboxCapacity) {
        this.inboxCapacity = inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

        if(inbox.size()==inboxCapacity){
            Triple<Date,String,String>oldestMail = inbox.get(0);
          trash.add(oldestMail);
          inbox.remove(oldestMail);
        }
        Triple<Date,String,String> mail = Triple.of(date,sender,message);
        inbox.add(mail);
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing
        int index =-1;
        for(int i=0;i<inbox.size();i++) {
            if (inbox.get(i).getRight().equals(message)) {
                index =i;

                break;
            }
            if(index != -1){
                trash.add(inbox.get(index));
                inbox.remove(index);
            }
        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inbox.size()==0){
            return null;
        }else{
            return inbox.get(inbox.size()-1).getRight();
        }
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.size()==0){
            return null;
        }else{
            return inbox.get(0).getRight();
        }
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count=0;
        for (int i=0;i<inbox.size();i++) {
           if(inbox.get(i).getLeft().compareTo(start)>=0 && inbox.get(i).getLeft().compareTo(end)<=0)count++;
        }
        return count;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
trash.clear();
    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
    return this.inboxCapacity;
    }
}

package com.driver;

import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.Date;



public class Gmail extends Email {
    int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    ArrayList<Triple<Date,String,String>> inbox;  //collection of mails
    ArrayList<Triple<Date,String,String>> trash;  //collection of deleted mails
    public Gmail(String emailId, int inboxCapacity) {
       super(emailId);
      this.inboxCapacity = inboxCapacity;
      inbox = new ArrayList<>();  //initialisation
      trash = new ArrayList<>();  //initialisation
    }
    public void setInboxCapacity(int inboxCapacity) {
        this.inboxCapacity = inboxCapacity;
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

        if(inbox.size()==inboxCapacity){       //Arraylist size method use
            Triple<Date,String,String>oldestMail = inbox.get(0);   //first 0th mail in inbox
          trash.add(oldestMail);
          inbox.remove(oldestMail);
        }
        Triple<Date,String,String> mail = Triple.of(date,sender,message); //receive new mail add in inbox
        inbox.add(mail);
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

        for(int i=0;i<inbox.size();i++) {
            if (inbox.get(i).getRight().equals(message)) {  //right position is message in triplet
                trash.add(inbox.get(i)); //add that mail in trash & remove from inbox
                inbox.remove(i);
                break;
            }

        }
    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox
        if(inbox.isEmpty()){
            return null;
        }else{
            return inbox.get(inbox.size()-1).getRight();
        }
    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox
        if(inbox.isEmpty()){
            return null;
        }else{
            return inbox.get(0).getRight();
        }
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int mailcount=0;
        for (int i=0;i<inbox.size();i++) {
           if(inbox.get(i).getLeft().compareTo(start)>=0 && inbox.get(i).getLeft().compareTo(end)<=0)mailcount++;
           //date is greater or equal to start & less or equal to end date count++
        }
        return mailcount;

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

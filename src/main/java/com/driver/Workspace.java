package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings

    public Workspace(String emailId) {
        // The inboxCapacity is equal to the maximum value an integer can store.
super(emailId,Integer.MAX_VALUE);
calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
      calendar.add(meeting);
    }

    public int findMaxMeetings(){
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

        int count =0;
        ArrayList<Pair<LocalTime,Integer>>endtime = new ArrayList<>();   //time ,index pair into Arraylist
        for (int i=0;i<calendar.size();i++){
            endtime.add(Pair.of(calendar.get(i).getEndTime(),i));
        }
        Collections.sort(endtime);  //sorting meedting endtime

        LocalTime localTime = endtime.get(0).getLeft();
        if(!endtime.isEmpty())count++;
        for (int i=1;i<endtime.size();i++){
            if (calendar.get(endtime.get(i).getRight()).getStartTime().compareTo(localTime)>0) {
                count++;
                localTime = endtime.get(i).getLeft();
            }
        }
        return count;
    }
}

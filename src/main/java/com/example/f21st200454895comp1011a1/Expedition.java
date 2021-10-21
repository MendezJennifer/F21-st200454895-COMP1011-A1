package com.example.f21st200454895comp1011a1;

public class Expedition {
    private int expID;
    private String expName;
    private int year;
    private String nation;
    private boolean success;
    private int duration;

    public Expedition(String expName, int year, String nation, boolean success, int duration) {
        this.expName = expName;
        this.year = year;
        this.nation = nation;
        this.success = success;
        this.duration = duration;
        expID=0;
    }

    public int getExpID() {
        return expID;
    }

    public void setExpID(int expID) {
        if(expID>0)
            this.expID = expID;
        else
            throw new IllegalArgumentException("expedition Id must be greater than zero");
    }

    public String getExpName() {
        return expName;
    }

    public void setExpName(String expName) {
        if(expName.length()>2)
            this.expName = expName;
        else
            throw new IllegalArgumentException("Expedition Name must be at least 2 characters long");
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if(year>=2000 && year<=2021)
            this.year = year;
        else
            throw new IllegalArgumentException("Expedition year must be between 2000 and 2021");
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        if(nation.length()>2)
            this.nation = nation.substring(0,1).toUpperCase()+nation.substring(1);
        else
            throw new IllegalArgumentException("Expedition Nation must be at least 2 characters long");
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        if (duration>0)
            this.duration = duration;
        else
            throw new IllegalArgumentException("Duration of expedition must be greater than zero");
    }
}

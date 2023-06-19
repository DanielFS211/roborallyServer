package com.example.roborallyserver;

/**
 * The save class defines what values are in a save file and initalizes 2 getter methods for their savedata and names.
 * It is used by Springboot autowiring.
 */
public class Save {
    private String name;
    private String savedata;
    public Save()
    {

    }
    public Save(String name, String savedata)
    {
        this.name = name;
        this.savedata = savedata;
    }
    public String getSavedata(){return savedata;}
    public String getName(){return name;}

}

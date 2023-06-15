package com.example.roborallyserver;

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

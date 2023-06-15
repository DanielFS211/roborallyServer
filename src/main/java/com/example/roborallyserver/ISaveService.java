package com.example.roborallyserver;

import java.util.List;

public interface ISaveService {
    List<Save> findAll();
//    boolean newGame(Save s);
    public boolean newGame(String name, String saveData);
    public boolean updateSave(String name, String saveData);
    public String loadGame(String name);


    public boolean deleteSave(String name);

}

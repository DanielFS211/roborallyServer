package com.example.roborallyserver;

import java.util.List;

/**
 * The ISaveService is an interface that defines the method signatures for SaveService to use.
 */
public interface ISaveService {
    List<Save> findAll();
    public boolean newGame(String name, String saveData);
    public boolean updateSave(String name, String saveData);
    public String loadGame(String name);


    public boolean deleteSave(String name);

}

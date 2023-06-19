package com.example.roborallyserver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * The SaveService class implements the methods defined in ISaveService and uses them.
 * The logic for the methods from the interface is defined in here.
 */
@Service
public class SaveService implements ISaveService
{
    ArrayList<Save> saves = new ArrayList<Save>();

    /**
     * Adds some dummy saves for testing.
     */
    public SaveService() {
        saves.add(new Save("save 1 test","stringsave"));
        saves.add(new Save("save 2 test", "randomstringsave"));
    }

    /**
     * Gives you a list of all the saves.
     * @return List with saves.
     */
    @Override
    public List<Save> findAll() {
        return saves;
    }

    /**
     * Makes a save with the name and save data you give it.
     * @param name Name of save.
     * @param saveData JSON string.
     * @return returns true if adding the save is succesful.
     */
    @Override
    public boolean newGame(String name, String saveData) {
        saves.add(new Save(name, saveData));
        return true;
    }

    /**
     * Updates an existing save with the name given with the save data given as parameter.
     * @param name Name of save.
     * @param saveData JSON string.
     * @return returns true if adding the save is succesful.
     */
    @Override
    public boolean updateSave(String name, String saveData) {
        for (int i = 0; i < saves.size(); i++) {
            if (saves.get(i).getName().equals(name)){
                saves.set(i, new Save(name, saveData));
            }
        } return true;
    }

    /**
     * Loads a game with the given name and returns the save as a JSON string.
     * @param name name of save.
     * @return savegame as a string.
     */
    @Override
    public String loadGame(String name) {
        String newSave = null;
        for (int i = 0; i < saves.size(); i++) {
            if (saves.get(i).getName().equals(name)){
                newSave = saves.get(i).getSavedata();
                break;
            }
        }
        return newSave;
    }

    /**
     * Deletes the save with the given name. Returns true if successful and false if not.
     * @param name name of save you wanna delete.
     * @return True if successful and false if not.
     */
    @Override
    public boolean deleteSave(String name) {
        ArrayList<Save> newSaves = new ArrayList<Save>();
        int oldSize = saves.size();
        for(int i = 0; i <saves.size(); i++ ){
            if (!saves.get(i).getName().equals(name)){
                newSaves.add(saves.get(i));
            }
        }
        saves = newSaves;
        return oldSize < saves.size() ? true : false;
    }

}

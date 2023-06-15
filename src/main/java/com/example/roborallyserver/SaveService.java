package com.example.roborallyserver;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SaveService implements ISaveService
{

    ArrayList<Save> saves = new ArrayList<Save>();

    public SaveService() {
        saves.add(new Save("save 1 test","stringsave"));
        saves.add(new Save("save 2 test", "randomstringsave"));
    }

    @Override
    public List<Save> findAll() {
        return saves;
    }

//    @Override
//    public boolean newGame(Save s) {
//        saves.add(s);
//        return true;
//    }
    @Override
    public boolean newGame(String name, String saveData) {
        saves.add(new Save(name, saveData));
        return true;
    }

    @Override
    public boolean updateSave(String name, String saveData) {
        for (int i = 0; i < saves.size(); i++) {
            if (saves.get(i).getName().equals(name)){
                saves.set(i, new Save(name, saveData));
            }
        } return true;
    }
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

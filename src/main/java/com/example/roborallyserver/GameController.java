package com.example.roborallyserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * The GameController is a REST controller that handles HTTP requests and "wires" them to the appropiate
 * methods in save service.
 */
@RestController
public class GameController {
    public GameController() {
    }

    @Autowired
    private ISaveService saveService;

    /**
     * Updates a game save with the specified name.
     * @param name The name of the game save to update.
     * @param jsonBoardTemplateString The JSON string representing the updated board template.
     * @return Returns a response indicating the success of the operation.
     */
    @PutMapping("/saves/{name}")
    public ResponseEntity<String> saveGame(@PathVariable String name, @RequestBody String jsonBoardTemplateString) {
        boolean added = saveService.updateSave(name, jsonBoardTemplateString);
        return ResponseEntity.ok("ok");
    }

    /**
     * Loads a game save with the specified name.
     * @param name The name of the game save to load.
     * @return Returns a response containing the loaded game save as a string.
     */
    @GetMapping("/saves/{name}")
    public ResponseEntity<String> loadGame(@PathVariable String name) {
        String save = saveService.loadGame(name);
        return ResponseEntity.ok().body(save);
    }
    /**
     * Retrieves all the saves.
     * @return Returns a list of all the save files.
     */
    @GetMapping(value = "/saves")
    public ResponseEntity<List<Save>> getSaves() {
        List<Save> saves = saveService.findAll();
        return ResponseEntity.ok().body(saves);
    }
    /**
     * Creates a new game save with the specified name and board template.
     * @param name The name of the game save.
     * @param jsonBoardTemplateString The JSON string representing the board template.
     * @return Returns a response indicating the success of the operation.
     */
    @PostMapping("/saves/{name}")
    public ResponseEntity<String> newGame(@PathVariable String name, @RequestBody String jsonBoardTemplateString) {
        boolean added = saveService.newGame(name, jsonBoardTemplateString);
        return ResponseEntity.ok("ok");
    }
    /**
     * Deletes a game save with the specified name.
     * @param name The name of the game save to be deleted.
     * @return Returns a response indicating the success of the operation.
     */
    @DeleteMapping("/saves")
    public ResponseEntity<String> deleteSave(@RequestParam(value = "name") String name) {
        saveService.deleteSave(name);
        return ResponseEntity.ok().body("deleted");
    }
}


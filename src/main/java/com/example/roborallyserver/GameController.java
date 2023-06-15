package com.example.roborallyserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping("/api")
public class GameController {
    private RoboRallyLogic roboRallyLogic;  // your game logic goes here

    public GameController() {
    }

    @Autowired
    private ISaveService saveService;

    //Works.
    @PutMapping("/saves/{name}")
    public ResponseEntity<String> saveGame(@PathVariable String name, @RequestBody String jsonBoardTemplateString) {
        boolean added = saveService.updateSave(name, jsonBoardTemplateString);
        return ResponseEntity.ok("ok");
    }

    //Works.
    @GetMapping("/saves/{name}")
    public ResponseEntity<String> loadGame(@PathVariable String name) {
        // process the action and return the new game state
        String save = saveService.loadGame(name);
//        Gson gson = new Gson();
//        gson.toJson(save);
        return ResponseEntity.ok().body(save);
    }

    //Test, works.
    @GetMapping(value = "/saves")
    public ResponseEntity<List<Save>> getSaves() {
        List<Save> saves = saveService.findAll();
        return ResponseEntity.ok().body(saves);
    }


    @PostMapping("/saves/{name}")
    public ResponseEntity<String> newGame(@PathVariable String name, @RequestBody String jsonBoardTemplateString) {
        // process the action and return the new game stat
        // A SAVE IS it's own class and not a string. fix this
        // e;
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        gson.toJson(jsonBoardTemplateString);

        boolean added = saveService.newGame(name, jsonBoardTemplateString);
//        String jsonBoardTemplate = null;
//        String ba = "saves/";
//        s.toString()  = jsonBoardTemplate;

        return ResponseEntity.ok("ok");
    }
    @DeleteMapping("/saves")
    public ResponseEntity<String> deleteSave(@RequestParam(value = "name") String name) {
        saveService.deleteSave(name);
        return ResponseEntity.ok().body("deleted");
    }

}

 /*   @PostMapping("/game/start")
    public ResponseEntity<GameState> startGame(@RequestBody GameStartRequest request) {
        GameState gameState = gameService.startNewGame(request.getNumberOfPlayers(), request.getGameBoardName());
        return ResponseEntity.ok(gameState);
    }

    public class GameStartRequest {
        private int numberOfPlayers;
        private String gameBoardName;
        // getters and setters...
    }


    @PostMapping("/game/save")
    public ResponseEntity<String> saveGame(@RequestBody GameState gameState) {
        gameService.saveGame(gameState);
        return ResponseEntity.ok("Game saved successfully");
    }


    @GetMapping("/game/load/{saveId}")
    public ResponseEntity<GameState> loadGame(@PathVariable String saveId) {
        GameState gameState = gameService.loadGame(saveId);
        return ResponseEntity.ok(gameState);
    }

    @DeleteMapping("/game/stop")
    public ResponseEntity<String> stopGame() {
        gameService.stopGame();
        return ResponseEntity.ok("Game stopped successfully");
    }*/




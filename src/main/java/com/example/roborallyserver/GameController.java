package com.example.roborallyserver;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
//@RequestMapping("/api")
public class GameController {
    private RoboRallyLogic roboRallyLogic;  // your game logic goes here

    public GameController() {
    }



    @PostMapping("/saveGame/{name}")
    public ResponseEntity<String> saveGame(@PathVariable String name, @RequestBody String boardTemplate) {
        // process the action and return the new game stat
        // e

        return ResponseEntity.ok("ok");
    }

    @GetMapping("/loadGame")
    public ResponseEntity<String> loadGame(@RequestBody String name) {
        // process the action and return the new game state

        return ResponseEntity.ok("JSONFIL");
    }

    @PostMapping("/newGame")
    public ResponseEntity<String> newGame (@PathVariable String name, @RequestBody String boardTemplate){

        return ResponseEntity.ok("Starting Game");
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




package com.hexaware.springrest.cricket.controller;

import com.hexaware.springrest.cricket.DTO.PlayerDTO;
import com.hexaware.springrest.cricket.service.IPlayerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired
    private IPlayerService playerService;

    @GetMapping
    public List<PlayerDTO> getAllPlayers() {
        return playerService.getAllPlayers();
    }
    
    @GetMapping("/{playerId}")
    public ResponseEntity<PlayerDTO> getPlayerById(@PathVariable int playerId) {
        PlayerDTO playerDTO = playerService.getPlayerById(playerId);
        return new ResponseEntity<>(playerDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<PlayerDTO> addPlayer(@Valid @RequestBody PlayerDTO playerDTO) {
        PlayerDTO savedPlayer = playerService.addPlayer(playerDTO);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }

    @PutMapping("/{playerId}")
    public ResponseEntity<PlayerDTO> updatePlayer(@PathVariable int playerId, @Valid @RequestBody PlayerDTO playerDTO) {
        PlayerDTO updatedPlayer = playerService.updatePlayer(playerId, playerDTO);
        return new ResponseEntity<>(updatedPlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{playerId}")
    public ResponseEntity<String> deletePlayer(@PathVariable int playerId) {
        playerService.deletePlayer(playerId);
        return new ResponseEntity<>("Player deleted successfully", HttpStatus.OK);
    }
    
    @GetMapping("/team/{teamName}")
    public List<Map<String, Object>> getPlayersByTeam(@PathVariable String teamName) {
        return playerService.getPlayerStatsByTeam(teamName);
    }
    

    @GetMapping("/country/{countryName}")
    public List<Map<String, Object>> getPlayersByCountry(@PathVariable String countryName) {
        return playerService.getPlayerStatsByCountry(countryName);
    }
}
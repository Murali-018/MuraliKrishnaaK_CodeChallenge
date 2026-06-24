package com.hexaware.springrest.cricket.service;

import com.hexaware.springrest.cricket.DTO.PlayerDTO;
import java.util.List;
import java.util.Map;

public interface IPlayerService {
 
	PlayerDTO addPlayer(PlayerDTO playerDTO);
	List<PlayerDTO> getAllPlayers();
	PlayerDTO updatePlayer(int playerId,PlayerDTO playerDTO);
	void deletePlayer(int playerId);
	PlayerDTO getPlayerById(int playerId);
	List<Map<String, Object>> getPlayerStatsByTeam(String teamName);
	List<Map<String, Object>> getPlayerStatsByCountry(String countryStateName);
}

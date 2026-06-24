package com.hexaware.springrest.cricket.service;

import com.hexaware.springrest.cricket.DTO.PlayerDTO;
import com.hexaware.springrest.cricket.entity.Player;
import com.hexaware.springrest.cricket.repository.PlayerRepository;
import com.hexaware.springrest.cricket.exception.PlayerAlreadyExistsException;
import com.hexaware.springrest.cricket.exception.PlayerNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlayerServiceImpl implements IPlayerService {

    @Autowired
    private PlayerRepository playerRepository;

	@Override
	public PlayerDTO addPlayer(PlayerDTO playerDTO) {
		boolean exists = playerRepository.existsById(playerDTO.getPlayerId());
	    
	    if (exists) {
	        
	        throw new PlayerAlreadyExistsException();
	    }
		Player player = convertToEntity(playerDTO);
        Player savedPlayer = playerRepository.save(player);
        return convertToDTO(savedPlayer);
	}


	@Override
	public PlayerDTO getPlayerById(int playerId) {
	    Player player = playerRepository.findById(playerId)
	            .orElseThrow(() -> new PlayerNotFoundException());
	    return convertToDTO(player);
	}

	@Override
	public List<PlayerDTO> getAllPlayers() {
		return playerRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
	}

	@Override
	public PlayerDTO updatePlayer(int playerId, PlayerDTO playerDTO) {
		Player existingPlayer = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException());

        
        existingPlayer.setPlayerName(playerDTO.getPlayerName());
        existingPlayer.setJerseyNumber(playerDTO.getJerseyNumber());
        existingPlayer.setRole(playerDTO.getRole());
        existingPlayer.setTotalMatches(playerDTO.getTotalMatches());
        existingPlayer.setTeamName(playerDTO.getTeamName());
        existingPlayer.setCountryStateName(playerDTO.getCountryStateName());
        existingPlayer.setDescription(playerDTO.getDescription());

        Player updatedPlayer = playerRepository.save(existingPlayer);
        return convertToDTO(updatedPlayer);
	}

	@Override
	public void deletePlayer(int playerId) {
		Player player = playerRepository.findById(playerId)
                .orElseThrow(() -> new PlayerNotFoundException());
        playerRepository.delete(player);
	}
	
	private Player convertToEntity(PlayerDTO dto) {
        Player player = new Player();
        player.setPlayerId(dto.getPlayerId());
        player.setPlayerName(dto.getPlayerName());
        player.setJerseyNumber(dto.getJerseyNumber());
        player.setRole(dto.getRole());
        player.setTotalMatches(dto.getTotalMatches());
        player.setTeamName(dto.getTeamName());
        player.setCountryStateName(dto.getCountryStateName());
        player.setDescription(dto.getDescription());
        return player;
    }

    
    private PlayerDTO convertToDTO(Player player) {
        PlayerDTO dto = new PlayerDTO();
        dto.setPlayerId(player.getPlayerId());
        dto.setPlayerName(player.getPlayerName());
        dto.setJerseyNumber(player.getJerseyNumber());
        dto.setRole(player.getRole());
        dto.setTotalMatches(player.getTotalMatches());
        dto.setTeamName(player.getTeamName());
        dto.setCountryStateName(player.getCountryStateName());
        dto.setDescription(player.getDescription());
        return dto;
    }
}

package com.hexaware.springrest.cricket.repository;

import com.hexaware.springrest.cricket.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Map;


@Repository
public interface PlayerRepository extends JpaRepository<Player,Integer>{
List<Player> findByTeamName(String teamName);
@Query("SELECT p.playerName as playerName, p.totalMatches as totalMatches FROM Player p WHERE p.teamName = :teamName")
List<Map<String, Object>> findNameAndMatchesByTeam(@Param("teamName") String teamName);

@Query("SELECT p.playerName as playerName, p.totalMatches as totalMatches FROM Player p WHERE p.countryStateName = :countryStateName")
List<Map<String, Object>> findNameAndMatchesByCountry(@Param("countryStateName") String countryStateName);
}

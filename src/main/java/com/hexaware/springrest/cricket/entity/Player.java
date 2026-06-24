package com.hexaware.springrest.cricket.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name="players")
@Data
@NoArgsConstructor
public class Player {
  @Id
  @Column (name="player_id")
  private int playerId;
  
  @Column(name = "player_name")
  private String playerName;
  
  @Column(name="jersey_number")
  private int jerseyNumber;
  
  @Column(name = "role")
  private String role;
  
  @Column (name="total_matches")
  private int totalMatches;
  
  @Column(name = "team_name")
  private String teamName;
  
  @Column(name="Country_state_name")
  private String countryStateName;
  
  @Column(name="description")
  private String description;
}

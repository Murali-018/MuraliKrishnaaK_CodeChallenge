package com.hexaware.springrest.cricket.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {

    @NotNull(message = "Player ID is required")
    private Integer playerId; 

    @NotBlank(message = "Player Name cannot be blank")
    private String playerName;

    @NotNull(message = "Jersey Number is required")
    @Min(value = 1, message = "Jersey Number must be a positive number greater than 0")
    private Integer jerseyNumber; 

    @NotBlank(message = "Player Role is required")
    @Pattern(regexp = "^(Batsman|Bowler|Keeper|All Rounder)$", 
             message = "Role must be exactly one of these: Batsman, Bowler, Keeper, All Rounder")
    private String role; 

    @Min(value = 0, message = "Total Matches played cannot be a negative value")
    private int totalMatches;  

    @NotBlank(message = "Team Name cannot be blank")
    private String teamName; 

    @NotBlank(message = "Country/State Name cannot be blank")
    private String countryStateName; 

    @NotBlank(message = "Player Description  cannot be blank")
    private String description; 
}
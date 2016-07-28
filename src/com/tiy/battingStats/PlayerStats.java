package com.tiy.battingStats;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerStats
{
	private ArrayList<Player> listOfPlayers = new ArrayList<>();
	
	private static Scanner userInput = new Scanner(System.in);
	
	public Integer addPlayer()
	{
		String playerName;
		
		System.out.println("Please enter the players name: ");
		playerName = userInput.nextLine();
		
		listOfPlayers.add(new Player(playerName));
		
		return (listOfPlayers.size() - 1);
	}
	
	public Integer timesAtBat(Integer rosterPosition)
	{
		System.out.format("Please enter the number of times %s batted:\n", listOfPlayers.get(rosterPosition).getName());
		return userInput.nextInt();
	}
	
		
	public static void main(String[] args)
	{
		PlayerStats myRoster = new PlayerStats();
		boolean addPlayerSwitch = true;
		
		while(addPlayerSwitch)
		{
			System.out.println("Would you like to add a player?");
			if(userInput.nextLine().equalsIgnoreCase("Y"))
			{
				Integer rosterPosition = myRoster.addPlayer();
				
				System.out.println("");
				
				Integer timesAtBat = myRoster.timesAtBat(rosterPosition);
				
				for(int i = 0; i < timesAtBat; i++)
				{
					myRoster.addBattingResult(rosterPosition);
				}
			}
			else if(userInput.nextLine().equalsIgnoreCase("N"))
			{
				addPlayerSwitch = false;
			}
		}
		
	}

}

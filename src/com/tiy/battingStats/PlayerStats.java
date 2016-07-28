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
			}
			else if(userInput.nextLine().equalsIgnoreCase("N"))
			{
				addPlayerSwitch = false;
			}
		}
		
	}

}

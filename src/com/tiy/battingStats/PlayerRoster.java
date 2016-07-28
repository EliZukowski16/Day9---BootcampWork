package com.tiy.battingStats;

import java.util.ArrayList;
import java.util.Scanner;

public class PlayerRoster
{
	private ArrayList<Player> listOfPlayers = new ArrayList<>();
	
	private static Scanner userInput = new Scanner(System.in);
	
	private Integer addPlayerName()
	{
		String playerName;
		
		System.out.println("Please enter the players name: ");
		playerName = userInput.nextLine();
		
		listOfPlayers.add(new Player(playerName));
		
		return (listOfPlayers.size() - 1);
	}
	
	private Integer timesAtBat(Integer rosterPosition)
	{
		boolean notValidResult = true;
		String currentPlayer = listOfPlayers.get(rosterPosition).getName();
		Integer timesAtBat = 0;
		while(notValidResult)
		{
			System.out.format("Please enter the number of times %s batted:\n", currentPlayer);
			if(userInput.hasNextInt())
			{
				timesAtBat =  userInput.nextInt();
				
				if(timesAtBat > 0)
				{
					notValidResult = false;
				}
				else if(timesAtBat <= 0)
				{
					System.out.format("The number of times %s batted must be greater than 0\n", currentPlayer );
				}
			}
			else
			{
				userInput.next();
			}
		}
		
		return timesAtBat;
	}
	
	private void addBattingResult(Integer rosterPosition, Integer atBatNumber)
	{
		boolean notValidResult = true;
		Integer atBatResult;
		while(notValidResult)
		{
			System.out.println("Batting results are classified as:");
			System.out.println("No Bases - 0\n1st Base - 1\n2nd Base - 2\n3rd Base - 3\nHome Run - 4");
			System.out.format("Enter the batting result for %s\'s %d time at bat:\n", listOfPlayers.get(rosterPosition).getName(), (atBatNumber + 1));
			
			if(userInput.hasNextInt())
			{
				atBatResult = userInput.nextInt();

				switch(atBatResult)
				{
				case 0:
				case 1:
				case 2:
				case 3:
				case 4:
					listOfPlayers.get(rosterPosition).addAtBatResult(atBatResult);
					notValidResult = false;
					break;
				}
			}
			else
			{
				userInput.next();
			}
			
		}
	}
	
	public boolean createPlayer()
	{
		boolean createPlayer = false;
		
		System.out.println("Would you like to add a player?");
		if(userInput.nextLine().equalsIgnoreCase("Y"))
		{
			Integer rosterPosition = addPlayerName();
			String playerName = listOfPlayers.get(rosterPosition).getName();
			
			System.out.println("");
			
			Integer timesAtBat = timesAtBat(rosterPosition);
			
			for(int i = 0; i < timesAtBat; i++)
			{
				addBattingResult(rosterPosition, i);
			}
			
			Float battingAverage = listOfPlayers.get(rosterPosition).getBattingAverage();
			Float sluggingPercentage = listOfPlayers.get(rosterPosition).getSluggingPercentage();
			
			System.out.format("%s\'s batting average is: %2.3f\n", playerName, battingAverage);
			System.out.format("%s\'s slugging percentage is: %2.3f\n\n", playerName, sluggingPercentage);
			
			createPlayer = true;
			
		}
		else if(userInput.nextLine().equalsIgnoreCase("N"))
		{
			createPlayer = false;
		}
		
		return createPlayer;
	}
	
}

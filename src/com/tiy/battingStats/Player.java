package com.tiy.battingStats;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Player
{	
	private String playerName;
	private ArrayList<Integer> atBatResults = new ArrayList<>();
	private static Scanner userInput = new Scanner(System.in);
	
	
	
	public Player(String playerName)
	{
		this.playerName = playerName;
	}
	
	public void addAtBatResult(Integer atBatResult)
	{
		switch(atBatResult)
		{
		case 0: 
		case 1: 
		case 2:
		case 3: 
		case 4:
			atBatResults.add(atBatResult);
			break;
		}
	
	}
	
	public String getName()
	{
		return playerName;
	}
	
	public Float getBattingAverage()
	{
		Float battingAverage = 0.0f;
		Integer totalAtBats = 0;
		Integer totalHits = 0;
		
		totalAtBats = atBatResults.size();
		
		for(int i = 0; i < totalAtBats; i++)
		{
			switch(atBatResults.get(i))
			{
			case 0:
				break;
			case 1: 
				totalHits++;
				break;
			case 2: 
				totalHits++;
				break;
			case 3: 
				totalHits++;
				break;
			case 4:
				totalHits++;
				break;
			}
		}
		
		battingAverage = ((float) totalHits / (float) totalAtBats);
		
		return battingAverage;
		
	}
	
	public Float getSluggingPercentage()
	{
		Float sluggingPercentage = 0.0f;
		Integer totalBases = 0;
		Integer totalAtBats = 0;
		
		totalAtBats = atBatResults.size();
		
		for(int i = 0; i < totalAtBats; i++)
		{
			switch(atBatResults.get(i))
			{
			case 0:
				totalBases += 0;
				break;
			case 1:
				totalBases += 1;
				break;
			case 2:
				totalBases += 2;
				break;
			case 3:
				totalBases += 3;
				break;
			case 4:
				totalBases += 4;
				break;
			}
		}
		
		sluggingPercentage = (((float) totalBases) / ((float) totalAtBats));
		
		return sluggingPercentage;
	}
	
	public static void main(String[] args)
	{
		
		Player playerOne = new Player("John");
		
		Random random = new Random();
		
		for(int i = 0; i < 5; i++)
		{
			playerOne.addAtBatResult(random.nextInt(5));
		}
		
		playerOne.atBatResults.forEach(result->System.out.println(result));
		
		System.out.format("%.3f\n",playerOne.getBattingAverage());
		System.out.format("%.3f\n",playerOne.getSluggingPercentage());
		
	}

}

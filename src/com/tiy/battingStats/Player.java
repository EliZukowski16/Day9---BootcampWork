package com.tiy.battingStats;

import java.util.ArrayList;

public class Player
{	
	private String playerName;
	private ArrayList<Integer> atBatResults = new ArrayList<>();
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
		
}

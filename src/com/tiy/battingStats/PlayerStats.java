package com.tiy.battingStats;

public class PlayerStats
{

	public static void main(String[] args)
	{
		PlayerRoster myRoster = new PlayerRoster();
		boolean addPlayerSwitch = true;
		
		while(addPlayerSwitch)
		{
			addPlayerSwitch = myRoster.createPlayer();
		}
		
		System.out.println("Exiting batting stats application");
	}
}

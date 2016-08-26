package org.training.springbasics;

/**
 * POJO class to return ground name using constructor injection and return int
 * water using setter injection
 *
 */
public class Player {

	private String ground;
	private int water = 0;

	// constructor
	Player(String ground) {
		this.ground = ground;
	}

	// getter and setter methods
	public String getGround() {
		return ground;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public int getWater() {
		return water;
	}
}

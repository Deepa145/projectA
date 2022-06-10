package com.chainsys.springproject.beans;

public class ScoreBoard {
	public int targetScore;

	private ScoreBoard() {
		System.out.println("ScoreBoard object is created");
	}

	private ScoreBoard(int runs) {
		targetScore = runs;
		System.out.println("ScoreBoard object is created" + runs);
	}

// factory method - the method are static here
	public static ScoreBoard createObject() {
		return new ScoreBoard(240);
	}
	public static ScoreBoard createObject(int runs) {
		return new ScoreBoard(runs);
	}
}

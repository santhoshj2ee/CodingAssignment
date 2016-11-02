package com.n2services.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

/**
 * To calculate the sum of 5 different dice values based on various conditions 
 * @author santhosh
 */

public class DiceGame {
	private HashMap<Integer,Integer> singleMap;
	private HashMap<Integer, Integer> tripletMap;
	private HashMap<Integer, Integer> inputMap;
	
	public DiceGame() {
		singleMap = new HashMap<Integer,Integer>();
		tripletMap = new HashMap<Integer,Integer>();
		inputMap = new HashMap<Integer,Integer>();
	}
	
	/*
	 * Core logic for calculating the sum
	 */
	public Integer calculateScore(ArrayList<Integer> diceInput) {
		
		Integer total = 0;
		Integer balance = 0;
		initializeSingleMap();
		initializeTripletMap();
		initializeInputMap(diceInput);
		for(Integer input : inputMap.keySet()) {
			if(inputMap.get(input) >= 3) {
				total += tripletMap.get(input);
				balance = inputMap.get(input) - 3;
				if(balance > 0) {
					total += balance * singleMap.get(input);
				}
			} else {
				total += inputMap.get(input) * singleMap.get(input);
			}
		}
		return total;
	}

	/*
	 * Initalizing the input into a HashMap
	 */
	private void initializeInputMap(ArrayList<Integer> diceInput) {
		
		for (Integer number : diceInput) {
			if(inputMap.containsKey(number)) {
				inputMap.put(number, inputMap.get(number) + 1);
			} else {
				inputMap.put(number, 1);
			}
		}
	}

	/*
	 * Support HashMap intializing method carrying value for triplet numbers
	 */
	private void initializeTripletMap() {
		
		tripletMap.put(1,1000);
		tripletMap.put(2,200);
		tripletMap.put(3,300);
		tripletMap.put(4,400);
		tripletMap.put(5,500);
		tripletMap.put(6,600);
	}

	/*
	 * Support HashMap intializing method carrying value for single numbers
	 */
	private void initializeSingleMap() {

		singleMap.put(1,100);
		singleMap.put(2,0);
		singleMap.put(3,0);
		singleMap.put(4,40);
		singleMap.put(5,0);
		singleMap.put(6,0);
	}
	
	/*
	 * To Randomly generate 5 input values 
	 */
	private Integer[] randomInputArray() {
		Random rand = new Random();
		Integer[] inputArray = new Integer[5];
		for(int i=0;i<5;i++) {
			inputArray[i] = rand.nextInt(5) + 1;
		}
		return inputArray;
		
	}
	
	public static void main(String[] args){
		DiceGame game = new DiceGame();
		Integer [] array = game.randomInputArray();
		System.out.println("Input Values "+Arrays.toString(array));
		System.out.println(game.calculateScore(new ArrayList<Integer>(Arrays.asList(array))));
		
	}
}

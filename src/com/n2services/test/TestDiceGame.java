package com.n2services.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.n2services.game.DiceGame;

public class TestDiceGame {

 private DiceGame game;	

 @Before
 public void setUp() {
	 game = new DiceGame();
 }
  
 @Test
 public void performDiceTest() {
	 Integer expected = 280;
	 Integer actual = game.calculateScore(new ArrayList<Integer>(Arrays.asList(1,4,4,3,1)) );
	 assertEquals(expected,actual);
 }
  
}



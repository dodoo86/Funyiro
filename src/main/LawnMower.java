package main;

import java.util.ArrayList;

public class LawnMower {

	protected static int fuel;
	protected static int distance = 0;
	protected int[][] input;
	protected int curPos = 0;
	protected int curCol = 0;
	protected int grassCollected = 0;
	protected int bladeHeight;
	protected int holdSize;
	protected boolean hasHold = false;
	boolean endReached = false;
	boolean holderFull = false;
	
	ArrayList<String> dir = new ArrayList<String>();
	
	LawnMower(int ful, int[][] inp, int bladeh) {
		
		fuel = ful;
		input = inp;
		bladeHeight = bladeh;
		
	}
	
	
	
	public void start() {
		checkStatus(Iterate());
		printArray();
		
	}
	
	protected void checkStatus(ArrayList<String> dir) {
			
		checkIfFinished();
		checkBattery();	

	}		
	
	protected ArrayList<String> Iterate() {

		
		
	
		for(int i = 0; i < input.length; i++) {
			
		while(curPos < input[curCol].length -1 && curCol % 2 == 0 && turnAround() != true && holderFull == false) {
			System.out.println("Right");
			curPos++;
			distance++;
			dir.add("Left");
			cutGrass();
			
			if(curPos == input[curCol].length -1 && curCol !=  input.length -1 && holderFull == false) {
				System.out.println("Down");
				curCol++;
				distance++;
				cutGrass();
				dir.add("Up");
	
			}
		}
		
		while(curPos > 0 && curCol % 2 == 1 && turnAround() != true && holderFull == false) {
			System.out.println("Left");
			curPos--;
			distance++;
			dir.add("Right");
			cutGrass();
			
			if(curPos == 0 && curCol !=  input.length -1 && holderFull == false) {
				System.out.println("Down");
				curCol++;
				distance++;
				cutGrass();
				dir.add("Up");
				
			}
		}
	}
		
		return dir;
		
	}
		
	
	protected void cutGrass() {
		
		if(input[curCol][curPos] >= bladeHeight && bladeHeight > 0 && hasHold == false) {
			
			grassCollected += input[curCol][curPos] - bladeHeight;
			input[curCol][curPos] = bladeHeight;
			
		}
	}
	
	protected static boolean turnAround() {
		
		if(fuel  / 2 <= distance)
			return true;
		else
			return false;
		
	}
	
	protected void printArray() {
		
		System.out.println("\n");
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++)
				System.out.print(input[i][j] + " ");
			System.out.println();
			
		}	
	}
	
	protected void returnToBase() {
		
		for(int i = dir.size() -1 ; i >= 0; i--) {
			System.out.println(dir.get(i));
			}
		
			curPos = 0;
		    curCol = 0;
		    
	}
	
	protected void checkIfFinished() {
	
		if(turnAround() != true && holderFull == false ) {
			
			distance = distance * 2;
			
			System.out.println("\n");
			System.out.println("Job done returning to base");
			System.out.println(grassCollected + " grass was cutted");
			System.out.println("\n");
			
			returnToBase();
			endReached = true;
		}	
	}
	
	protected void checkBattery() {
		
		if(turnAround() == true && holderFull != true && endReached == false) {
			
			System.out.println("\n");
			System.out.println("Battery low... returning to base ! ");
			System.out.println(grassCollected + " grass was cutted");
			System.out.println("\n");
			
			returnToBase();
			
		}	
	}
}


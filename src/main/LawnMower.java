package main;

import java.util.ArrayList;

public class LawnMower {

	private static int fuel;
	private static int distance = 0;
	private int[][] input;
	private int curPos = 0;
	private int curCol = 0;
	private int grassCollected = 0;
	private int bladeHeight;
	private int holdSize;
	private boolean hasHold = false;
	boolean endReached = false;
	boolean holderFull = false;
	
	LawnMower(int ful, int[][] inp, int bladeh) {
		
		fuel = ful;
		input = inp;
		bladeHeight = bladeh;
		
	}
	
	LawnMower(int ful, int[][] inp, int bladeh, boolean has, int size) {
		
		fuel = ful;
		input = inp;
		bladeHeight = bladeh;
		holdSize = size;
		hasHold = has;
		
	}
	
	public void start() {
		checkStatus(Iterate());
		printArray();
		
	}
	
	public ArrayList<String> Iterate() {

		
		ArrayList<String> dir = new ArrayList<String>();
	
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
			} else {
				endReached = true;
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
			} else {
				endReached = true;
			}

		}
		
	}
		
		return dir;
		
	}
		
	
	private void cutGrass() {
		
		if(input[curCol][curPos] >= bladeHeight && bladeHeight > 0 && hasHold == false) {
			
			grassCollected += input[curCol][curPos] - bladeHeight;
			input[curCol][curPos] = bladeHeight;
			
		}
		
		if(holdSize > grassCollected && input[curCol][curPos] >= bladeHeight && bladeHeight > 0 && hasHold == true && holderFull == false) {
			grassCollected += input[curCol][curPos] - bladeHeight;
			input[curCol][curPos] = bladeHeight;
			
		}else if (holdSize <= grassCollected && hasHold == true) {
				holderFull = true;
				if(grassCollected / holdSize == 1 && hasHold == true && curCol % 2 == 1) {
					System.out.println(grassCollected);
					System.out.println(holdSize);
					input[curCol ][curPos +1] = bladeHeight + (grassCollected - holdSize);
					grassCollected = holdSize;
				}
				if(grassCollected / holdSize == 1 && hasHold == true && curCol % 2 == 0) {
					System.out.println(grassCollected);
					System.out.println(holdSize);
					input[curCol ][curPos -1] = bladeHeight + (grassCollected - holdSize);
					grassCollected = holdSize;
				}
			}
	}
	
	private static boolean turnAround() {
		
		if(fuel  / 2 <= distance)
			return true;
		else
			return false;
		
	}
	
	private void printArray() {
		
		System.out.println("\n");
		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[i].length; j++)
				System.out.print(input[i][j] + " ");
			System.out.println();
		}
		
	}
	
	public void checkStatus(ArrayList<String> dir) {
		
		
		if(turnAround() == true && holderFull == true && hasHold == true) {
			
			System.out.println("\n");
			System.out.println("Battery low and grass holder full... returning to base ! ");
			System.out.println(grassCollected + " grass was cutted");
			System.out.println("\n");
			
			for(int i = dir.size() -1 ; i >= 0; i--) {
				System.out.println(dir.get(i));
				}
			
				curPos = 0;
			    curCol = 0;
			    
		}
		
		if(turnAround() == true && holderFull != true) {
			
			System.out.println("\n");
			System.out.println("Battery low... returning to base ! ");
			System.out.println(grassCollected + " grass was cutted");
			System.out.println("\n");
			
			for(int i = dir.size() -1 ; i >= 0; i--) {
				System.out.println(dir.get(i));
				}
			
				curPos = 0;
			    curCol = 0;
			
		}
		
		if(turnAround() != true && holderFull == false ) {
			
			distance = distance * 2;
			
			System.out.println("\n");
			System.out.println("Job done returning to base");
			System.out.println(grassCollected + " grass was cutted");
			System.out.println("\n");
			
			for(int i = dir.size() -1 ; i >= 0; i--) {
				System.out.println(dir.get(i));
				}
			
				curPos = 0;
			    curCol = 0;
		
		}
		if(holderFull == true && hasHold == true && turnAround() != true) {
			
			distance = distance * 2;
			
			
			System.out.println("\n");
			System.out.println("Grass holder full returning to base");
			System.out.println(grassCollected + " grass was collected");
			System.out.println("\n");
			
			for(int i = dir.size() -1 ; i >= 0; i--) {
				System.out.println(dir.get(i));
				}
			
				curPos = 0;
			    curCol = 0;
			
		}
		
			
		
	}
		
}


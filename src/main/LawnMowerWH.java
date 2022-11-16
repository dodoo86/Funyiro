package main;

import java.util.ArrayList;

public class LawnMowerWH extends LawnMower {
	
	

	LawnMowerWH(int ful, int[][] inp, int bladeh, boolean has, int size) {
		super(ful, inp, bladeh);
			
			fuel = ful;
			input = inp;
			bladeHeight = bladeh;
			holdSize = size;
			hasHold = has;
	
	}

	@Override
	protected void checkStatus(ArrayList<String> dir) {
		
		checkBatteryAndHolder();
		checkIfFinished();
		checkBattery();
		checkGrassHolder();

	}	
	
	@Override
	protected void cutGrass() {
		
		if(holdSize > grassCollected && input[curCol][curPos] >= bladeHeight && bladeHeight > 0 && hasHold == true && holderFull == false) {
			grassCollected += input[curCol][curPos] - bladeHeight;
			input[curCol][curPos] = bladeHeight;
			
		}else if (holdSize <= grassCollected && hasHold == true) {
			
				holderFull = true;
				
				if(grassCollected / holdSize == 1 && hasHold == true && curCol % 2 == 1) {
					input[curCol ][curPos +1] = bladeHeight + (grassCollected - holdSize);
					grassCollected = holdSize;
				}
				
				if(grassCollected / holdSize == 1 && hasHold == true && curCol % 2 == 0) {
					input[curCol ][curPos -1] = bladeHeight + (grassCollected - holdSize);
					grassCollected = holdSize;
				}
		}
	}
	
	protected void checkBatteryAndHolder() {
		
		if(turnAround() == true && holderFull == true && hasHold == true && endReached == false) {
					
					System.out.println("\n");
					System.out.println("Battery low and grass holder full... returning to base ! ");
					System.out.println(grassCollected + " grass was cutted");
					System.out.println("\n");
					
					returnToBase();
					
		}
	}
	
	protected void checkGrassHolder() {
		
		if(holderFull == true && hasHold == true && turnAround() != true && endReached == false) {
			
			distance = distance * 2;

			System.out.println("\n");
			System.out.println("Grass holder full returning to base");
			System.out.println(grassCollected + " grass was collected");
			System.out.println("\n");
			
			returnToBase();
			
		}	
	}
	
}

package main;

import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		
		int[][] field = { { 1, 2, 3, 3, 4, 5, 3 },
				  		  { 0, 3, 1, 4, 4, 5, 1 },
				  		  { 1, 4, 2, 0, 3, 0, 2 },
				  		  { 0, 1, 5, 2, 3, 1, 0 },
				  		  { 0, 2, 1, 4, 0, 3, 1 },
				  		  { 1, 5, 3, 1, 2, 1, 0 } };
		
		int[][] field2 = { { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
		  		  		   { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
		  		           { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
		  		           { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
		  		           { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
		  		           { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
		  		           { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
		  		           { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 },
		  		           { 1, 1, 1, 0, 1, 0, 1, 0, 0, 1 } };
		
		//LawnMower a = new LawnMower(12, field, 2);//, true, 5);
		LawnMower a = new LawnMower(200, field, 2, true, 8);
		//System.out.println(field.length);
		a.start();
		
		
		
		
		
		
	}

	
	
	
}

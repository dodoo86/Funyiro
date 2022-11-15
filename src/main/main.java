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
		
		int[][] field2 = { { 1, 2, 3, 3, 4, 5, 3, 4, 4, 5, 1 },
		  		  		   { 4, 2, 0, 3, 0, 2, 5, 2, 3, 1, 3 },
		  		           { 2, 1, 4, 0, 3, 4, 2, 0, 3, 0, 4 },
		  		           { 8, 1, 2, 5, 1, 6, 7, 5, 0, 2, 2 },
		  		           { 2, 8, 0, 3, 4, 2, 5, 3, 3, 1, 3 },
		  		           { 4, 0, 0, 3, 8, 2, 4, 1, 6, 1, 3 },
		  		           { 5, 2, 3, 8, 1, 7, 7, 4, 1, 2, 2 },
		  		           { 4, 2, 0, 3, 0, 2, 5, 2, 3, 1, 3 },
		  		           { 8, 1, 2, 5, 1, 6, 7, 5, 0, 2, 2 } };
		
		LawnMower a = new LawnMower(84, field, 1);//, true, 5);
		//LawnMower a = new LawnMower(82, field, 2, true, 29);
		//System.out.println(field.length);
		a.start();
		
		
		
		
		
		
	}

	
	
	
}

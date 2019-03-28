package main;

import java.awt.print.Printable;
import java.util.Random;

public class execute_mat {
//	int matrix_bot[][];

	public static void main(String[] args) {
		Random random = new Random();
		int[][] matrix_bot = new int[10][10];
		boolean repeat_3 = true;
		for (int i = 5; i > 1;) {
			if (check_direction(random.nextInt(10), random.nextInt(10), random.nextInt(4), i, matrix_bot)) {
				if (i == 3 && repeat_3) 
					repeat_3 = false;
				else
					i--;
			}
		}
		printM(matrix_bot);
	}
	
	public static void printM(int[][] matrix_usr) {
		for (int i = 0; i < matrix_usr.length; i++) {
			for (int j = 0; j < matrix_usr[0].length; j++) {
				System.out.print(matrix_usr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static boolean check_direction(int x, int y, int direction, int mode, int[][] matrix_bot) {
		switch(direction) {
			case 0:
				if((y-mode) < 0) {
					for(int i = 1; i <= (mode-y); i++)
						if(matrix_bot[y+i][x] == 1 || matrix_bot[y+i][x] == -1)
							return false;
					y += (mode-y);
				}else {
					for(int i = 0; i < mode; i++)
						if(matrix_bot[y-i][x] == 1 || matrix_bot[y-i][x] == -1)
							return false;
				}
				for(int i = 0; i < mode; i++)
					matrix_bot[y-i][x] = 1;
				return true;
				
			case 1:
				if((x+mode) > 9) {
					for(int i = 1; i <= ((mode+x)%9); i++)
						if(matrix_bot[y][x-i] == 1 || matrix_bot[y][x-i] == -1)
							return false;
					x -= ((x+mode)%9);
				}else {
					for(int i = 0; i < mode; i++)
						if(matrix_bot[y][x+i] == 1 || matrix_bot[y][x+i] == -1)
							return false;
				}
				for(int i = 0; i < mode; i++)
					matrix_bot[y][x+i] = 1;
				return true;
				
			case 2:
				if((y+mode) > 9) {
					for(int i = 1; i <= ((mode+y)%9); i++)
						if(matrix_bot[y-i][x] == 1 || matrix_bot[y-i][x] == -1)
							return false;
					y -= ((y+mode)%9);
				}else {
					for(int i = 0; i < mode; i++)
						if(matrix_bot[y+i][x] == 1 || matrix_bot[y+i][x] == -1)
							return false;
				}
				for(int i = 0; i < mode; i++)
					matrix_bot[y+i][x] = 1;
				return true;
				
			case 3:
				if((x-mode) < 0) {
					for(int i = 1; i <= (mode-x); i++)
						if(matrix_bot[y][x+i] == 1 || matrix_bot[y][x+i] == -1)
							return false;
					x += (mode-x);
				}else {
					for(int i = 0; i < mode; i++)
						if(matrix_bot[y][x-i] == 1 || matrix_bot[y][x-i] == -1)
							return false;
				}
				for(int i = 0; i < mode; i++)
					matrix_bot[y][x-i] = 1;
				return true;
		}
		return false;
	}

}

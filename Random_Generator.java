package main;

import java.util.Random;

public class Random_Generator {
	private int matrix_bot[][] = new int[10][10];
	
	
	public Random_Generator() {
//		matrix_bot = new int[10][10];
		engine();
	}
	
	public int[][] getMatrix_bot() {
		return matrix_bot;
	}

	void mat_clear() {
		for (int i = 0; i < 10; i++) 
			for (int j = 0; j < 10; j++) 
				matrix_bot[i][j] = 0;
	}
	
	void engine() {
		mat_clear();
		Random random = new Random();
		boolean repeat_3 = true;
		for (int i = 5; i > 1;) {
			if (check_direction(random.nextInt(10), random.nextInt(10), random.nextInt(4), i)) {
				i--;
				if (i == 2 && repeat_3) {
					repeat_3 = false;
					i++;
				}
			}
		}
	}
	
	public boolean check_direction(int x, int y, int direction, int mode) {
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

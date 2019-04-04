package main;

import java.awt.print.Printable;
import java.util.Random;
import java.util.Scanner;

public class execute_mat {
	static Point list;
	static int direction = 0;
	static boolean second = false;
	static int temp = -1;
	static Point temp_point;
	static int[][] matrix_visited = new int[10][10];

	public static void main(String[] args) {
		boolean user = true;
		
		Scanner sys = new Scanner(System.in);
		int[][] matrix_bot = getBotMat();
		int[][] matrix_usr = new int[10][10];
		int row;
		int column;
		for (int i = 0; i < 17; i++) {
			row = sys.nextInt();
			column = sys.nextInt();
			matrix_usr[row][column] = 1;
		}
		System.out.println("Bot Matrix is ");
		printM(matrix_bot);
		System.out.println();
		System.out.println("User Matrix is ");
		printM(matrix_usr);
		System.out.println();
		
		System.out.println("game start");
		for (int i = 0; i < 200; i++) {
			if (user) {
				row = sys.nextInt();
				column = sys.nextInt();
				System.out.println("user shoot "+row+" and "+column);
				if (matrix_bot[row][column] == 1) {
					System.out.println("hit");
					user = false;
				}else
					System.out.println("miss");
			}else {
				temp_point = rand_point();
				System.out.println("bot shoot "+temp_point.row+" and "+temp_point.column);
				while(shoot_usr(matrix_usr, temp_point)) {
					System.out.println("hit");
					if (second) 
						temp = direction;
					else
						second = true;
					list = temp_point;
//					list.add(temp_point);
					temp_point = rand_point();
					System.out.println("bot shoot "+temp_point.row+" and "+temp_point.column);
				}
				System.out.println("miss");
				if (second && temp != -1) {
//					list.clear();
					second = false;
					temp = -1;
					direction = 0;

				}
				
			}
			
			if (user) 
				user = false;
			else
				user = true;
		}
		
		
	}
	
	public static int[][] getBotMat(){
		Random random = new Random();
		int[][] matrix = new int[10][10];
		boolean repeat_3 = true;
		for (int i = 5; i > 1;) {
			if (check_direction(random.nextInt(10), random.nextInt(10), random.nextInt(4), i, matrix)) {
				i--;
				if (i == 2 && repeat_3) {
					repeat_3 = false;
					i++;
				}
			}
		}
		return matrix;
	}
	
	public static void printM(int[][] matrix_usr) {
		for (int i = 0; i < matrix_usr.length; i++) {
			for (int j = 0; j < matrix_usr[0].length; j++) {
				if (matrix_usr[i][j] == -1) 
					System.out.print("2 "); // instead of printing -1 print 2 (neglect sign, don't break matrix look)
				else
					System.out.print(matrix_usr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	
	public static boolean check_direction(int x, int y, int direction, int mode, int[][] matrix_bot) {
		if(matrix_bot[y][x] == 1 || matrix_bot[y][x] == -1)
			return false;
		switch(direction) {
			case 0:
				if((y-mode-1) < 0) {
					for(int i = 1; i <= (mode-y-1); i++)
						if(matrix_bot[y+i][x] == 1 || matrix_bot[y+i][x] == -1)
							return false;
					y += (mode-y-1);
				}else {
					for(int i = 0; i < mode; i++)
						if(matrix_bot[y-i][x] == 1 || matrix_bot[y-i][x] == -1)
							return false;
				}
				for(int i = 0; i < mode; i++) {
					matrix_bot[y-i][x] = 1;
					if ((x-1) >= 0)
						matrix_bot[y-i][x-1] = -1;
					if ((x+1) <= 9)
						matrix_bot[y-i][x+1] = -1;
				}
				if ((y+1) <= 9) {
					matrix_bot[y+1][x] = -1;
					if ((x-1) >= 0)
						matrix_bot[y+1][x-1] = -1;
					if ((x+1) <= 9)
						matrix_bot[y+1][x+1] = -1;
				}
				if ((y-mode) >= 0){
					matrix_bot[y-mode][x] = -1;
					if ((x-1) >= 0)
						matrix_bot[y-mode][x-1] = -1;
					if ((x+1) <= 9)
						matrix_bot[y-mode][x+1] = -1;
				}
				return true;
				
			case 1:
				if((x+mode-1) > 9) {
					for(int i = 1; i <= ((mode+x-1)%9); i++)
						if(matrix_bot[y][x-i] == 1 || matrix_bot[y][x-i] == -1)
							return false;
					x -= ((x+mode-1)%9);
				}else {
					for(int i = 0; i < mode; i++)
						if(matrix_bot[y][x+i] == 1 || matrix_bot[y][x+i] == -1)
							return false;
				}
				for(int i = 0; i < mode; i++) {
					matrix_bot[y][x+i] = 1;
					if ((y-1) >= 0)
						matrix_bot[y-1][x+i] = -1;
					if ((y+1) <= 9)
						matrix_bot[y+1][x+i] = -1;
				}
				if ((x+mode) <= 9) {
					matrix_bot[y][x+mode] = -1;
					if ((y-1) >= 0)
						matrix_bot[y-1][x+mode] = -1;
					if ((y+1) <= 9)
						matrix_bot[y+1][x+mode] = -1;
				}
				if ((x-1) >= 0){
					matrix_bot[y][x-1] = -1;
					if ((y-1) >= 0)
						matrix_bot[y-1][x-1] = -1;
					if ((y+1) <= 9)
						matrix_bot[y+1][x-1] = -1;
				}
				return true;
				
			case 2:
				if((y+mode-1) > 9) {
					for(int i = 1; i <= ((mode+y-1)%9); i++)
						if(matrix_bot[y-i][x] == 1 || matrix_bot[y-i][x] == -1)
							return false;
					y -= ((y+mode-1)%9);
				}else {
					for(int i = 0; i < mode; i++)
						if(matrix_bot[y+i][x] == 1 || matrix_bot[y+i][x] == -1)
							return false;
				}
				for(int i = 0; i < mode; i++) {
					matrix_bot[y+i][x] = 1;
					if ((x-1) >= 0)
						matrix_bot[y+i][x-1] = -1;
					if ((x+1) <= 9)
						matrix_bot[y+i][x+1] = -1;
				}
				if ((y+mode) <= 9) {
					matrix_bot[y+mode][x] = -1;
					if ((x-1) >= 0)
						matrix_bot[y+mode][x-1] = -1;
					if ((x+1) <= 9)
						matrix_bot[y+mode][x+1] = -1;
				}
				if ((y-1) >= 0){
					matrix_bot[y-1][x] = -1;
					if ((x-1) >= 0)
						matrix_bot[y-1][x-1] = -1;
					if ((x+1) <= 9)
						matrix_bot[y-1][x+1] = -1;
				}
				return true;
				
			case 3:
				if((x-mode-1) < 0) {
					for(int i = 1; i <= (mode-x-1); i++)
						if(matrix_bot[y][x+i] == 1 || matrix_bot[y][x+i] == -1)
							return false;
					x += (mode-x-1);
				}else {
					for(int i = 0; i < mode; i++)
						if(matrix_bot[y][x-i] == 1 || matrix_bot[y][x-i] == -1)
							return false;
				}
				for(int i = 0; i < mode; i++) {
					matrix_bot[y][x-i] = 1;
					if ((y-1) >= 0)
						matrix_bot[y-1][x-i] = -1;
					if ((y+1) <= 9)
						matrix_bot[y+1][x-i] = -1;
				}
				if ((x+1) <= 9) {
					matrix_bot[y][x+1] = -1;
					if ((y-1) >= 0)
						matrix_bot[y-1][x+1] = -1;
					if ((y+1) <= 9)
						matrix_bot[y+1][x+1] = -1;
				}
				if ((x-mode) >= 0){
					matrix_bot[y][x-mode] = -1;
					if ((y-1) >= 0)
						matrix_bot[y-1][x-mode] = -1;
					if ((y+1) <= 9)
						matrix_bot[y+1][x-mode] = -1;
				}
				return true;
		}
		return false;
	}

	public static boolean shoot_usr(int[][] matrix_usr, Point coord) {
		if (matrix_usr[coord.row][coord.column] == 1)
			return true;
		return false;
	}
	
	public static Point rand_point() {
		if (second ) {
			if (second  && temp != -1) 
				direction = temp;
//			while(true) {
				switch(direction) {
					case 0 : 
						if (matrix_visited[list.row-1][list.column] == 1) {
							direction = (direction+1)%4;
	//						return rand_point();
						}else {
							matrix_visited[list.row-1][list.column] = 1;
							return new Point(list.row-1, list.column);
						}
						
					case 1 : 
						if (matrix_visited[list.row][list.column+1] == 1) {
							direction = (direction+1)%4;
	//						return rand_point();
						}else {
							matrix_visited[list.row][list.column+1] = 1;
							return new Point(list.row, list.column+1);
						}	
					case 2 : 
						if (matrix_visited[list.row+1][list.column] == 1) {
							direction = (direction+1)%4;
	//						return rand_point();
						}else {
							matrix_visited[list.row+1][list.column] = 1;
							return new Point(list.row+1, list.column);
						}
					case 3 : 
						if (matrix_visited[list.row][list.column-1] == 1) {
							direction = (direction+1)%4;
	//						return rand_point();
						}else {
							matrix_visited[list.row][list.column-1] = 1;
							return new Point(list.row, list.column-1);
						}
				}
//			}
		}
		Random random = new Random();
		int row = random.nextInt(10);
		int column = random.nextInt(10);
		while(matrix_visited[row][column] == 1) {
			row = random.nextInt(10);
			column = random.nextInt(10);
		}
		matrix_visited[row][column] = 1;
		return new Point(row, column);
	}
}

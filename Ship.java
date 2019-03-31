package main;

import java.util.ArrayList;

import javax.swing.JButton;

class Point{
	int row = 0;
	int column = 0;
	public Point(int row, int column) {
		this.row = row;
		this.column = column;
	}
}

public class Ship {
	static ArrayList<Point> list = new ArrayList<>();
	static boolean check = false;
	static boolean row_boolean = false;
	static boolean column_boolean = false;
	
	
	
	
	public boolean ship_func(int[][] matrix, int mode, int row, int column) {
		if(matrix[row][column] == 1 || matrix[row][column] == -1)
			return false;
		if (check) {
			if (list.get(0).row == row) {
				row_boolean = true;
			} else if (list.get(0).column == column){
				column_boolean = true;
			}else
				return false;
			check = false;
		}
		if (row_boolean) {
			if (list.get(0).row != row)
				return false;
		} else if (column_boolean){
			if (list.get(0).column != column)
				return false;
		}
		if (list.size() > 0) {
			if (row_boolean) {
				for (int i = 0; i < list.size(); i++) {
					if (column == (list.get(i).column + 1) || column == (list.get(i).column - 1)) {
						list.add(new Point(row, column));
						if(list.size() == mode) {
							horizontal_surround(matrix);
							list.clear();
							row_boolean = false;
						}
						return true;
					}
				}
				return false;
			} else if (column_boolean){
				for (int i = 0; i < list.size(); i++) {
					if (row == (list.get(i).row + 1) || row == (list.get(i).row - 1)) {
						list.add(new Point(row, column));
						if(list.size() == mode) {
							vertical_surround(matrix);
							list.clear();
							column_boolean = false;
						}
						return true;
					}
				}
				return false;
			}else
				return false;
		}
		list.add(new Point(row, column));
		check = true;
		return true;
	}
	
	
	
	public void vertical_surround(int[][] matrix) {
		int min = 10;
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).row > max) 
				max = list.get(i).row;
			if (list.get(i).row < min) 
				min = list.get(i).row;
			if ((list.get(i).column-1) >= 0) 
				matrix[list.get(i).row][(list.get(i).column-1)] = -1;
			if ((list.get(i).column+1) <= 9) 
				matrix[list.get(i).row][(list.get(i).column+1)] = -1;
		}
		if (min != 0) {
			matrix[min-1][list.get(0).column] = -1;
			if ((list.get(0).column-1) >= 0) 
				matrix[min-1][(list.get(0).column-1)] = -1;
			if ((list.get(0).column+1) <= 9) 
				matrix[min-1][(list.get(0).column+1)] = -1;
		}
		if (max != 9) {
			matrix[max+1][list.get(0).column] = -1;
			if ((list.get(0).column-1) >= 0) 
				matrix[max+1][(list.get(0).column-1)] = -1;
			if ((list.get(0).column+1) <= 9) 
				matrix[max+1][(list.get(0).column+1)] = -1;
		}
	}
	
	
	public void horizontal_surround(int[][] matrix) {
		int min = 10;
		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).column > max) 
				max = list.get(i).column;
			if (list.get(i).column < min) 
				min = list.get(i).column;
			if ((list.get(i).row-1) >= 0) 
				matrix[list.get(i).row-1][(list.get(i).column)] = -1;
			if ((list.get(i).row+1) <= 9) 
				matrix[list.get(i).row+1][(list.get(i).column)] = -1;
		}
		if (min != 0) {
			matrix[list.get(0).row][min-1] = -1;
			if ((list.get(0).row-1) >= 0) 
				matrix[(list.get(0).row-1)][min-1] = -1;
			if ((list.get(0).row+1) <= 9) 
				matrix[(list.get(0).row+1)][min-1] = -1;
		}
		if (max != 9) {
			matrix[(list.get(0).row)][max+1] = -1;
			if ((list.get(0).row-1) >= 0) 
			matrix[(list.get(0).row-1)][max+1] = -1;
			if ((list.get(0).row+1) <= 9) 
			matrix[(list.get(0).row)+1][max+1] = -1;
		}
	}
	
	
	public static void reset(int[][] matrix, JButton arr[][]) {
		for (int i = 0; i < list.size(); i++) {
			matrix[list.get(i).row][list.get(i).column] = 0;
			arr[list.get(i).row][list.get(i).column].setBackground(null);
		}
		list.clear();
		check = false;
		row_boolean = false;
		column_boolean = false;
		
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

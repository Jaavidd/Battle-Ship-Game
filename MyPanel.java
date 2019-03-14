package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;


class Point{
	int x;
	int y;
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class MyPanel extends JPanel{
	GridLayout panelLayout;
	JButton arr[][];
	int matrix[][];
	private boolean ship_2 = false;
	private int ship_2_count = 1;
	private boolean ship_3 = false;
	private int ship_3_count = 2;
	private boolean ship_4 = false;
	private int ship_4_count = 1;
	private boolean ship_5 = false;
	private int ship_5_count = 1;
	
	MouseListener mouse;
	
	ArrayList<Point> ship_2_previous_coord;
	ArrayList<Point> ship_3_previous_coord;
	ArrayList<Point> ship_4_previous_coord;
	ArrayList<Point> ship_5_previous_coord;
	
	public MyPanel() {
		mouse = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = 0;
				int column = 0;
				for (int i = 0; i < arr.length; i++) {
					for (int j = 0; j < arr[0].length; j++) {
						if(arr[i][j] == e.getSource()) {
							row = i;
							column = j;
							break;
						}	
					}
				}
				if(ship_2) {
					if(ship_2_func(row, column)) {
//						System.out.println("inside ship_2");
						matrix[row][column] = 1;
						arr[row][column].setBackground(Color.RED);
					}
				} else if(ship_3) {
					if(ship_3_func(row, column)) {
//						System.out.println("inside ship_3");
						matrix[row][column] = 1;
						arr[row][column].setBackground(Color.RED);
					}
				} else if(ship_4) {
					if(ship_4_func(row, column)) {
//						System.out.println("inside ship_4");
						matrix[row][column] = 1;
						arr[row][column].setBackground(Color.RED);
					}
				} else if(ship_5) {
					if(ship_5_func(row, column)) {
//						System.out.println("inside ship_5");
						matrix[row][column] = 1;
						arr[row][column].setBackground(Color.RED);
					}
				}
				printM();
			}
		};
		panelLayout = new GridLayout(10,10);
		arr = new JButton[10][10];
		matrix = new int[10][10];
		
		ship_2_previous_coord = new ArrayList<Point>();
		ship_3_previous_coord = new ArrayList<Point>();
		ship_4_previous_coord = new ArrayList<Point>();
		ship_5_previous_coord = new ArrayList<Point>();
		
		setSize(new Dimension(800, 800));
		setVisible(true);
		setLayout(panelLayout);
		fill_BUTTONS();
		
	}
	
	public void fill_BUTTONS() {
		JButton bt;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				bt = new JButton();
				bt.addMouseListener(mouse);
				arr[i][j] = bt;
				add(bt);
			}
		}
	}
	
	
	public void set_bt_disable() {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j].removeMouseListener(mouse);
			}
		}
		
	}

	public void printM() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public void fill_PANEL_BOATS(int ship_type) {
		switch (ship_type) {
		case 2:
			if (ship_2_count != 0) {
				ship_2 = true;
			}
			break;
		case 3:
			if (ship_3_count != 0) {
				ship_3 = true;
				
			}
			break;
		case 4:
			if (ship_4_count != 0) {
				ship_4 = true;
				
			}
			break;
		default:
			if (ship_5_count != 0) {
				ship_5 = true;
				
		}
			break;
		}
	}
	
	public boolean ship_2_func(int row, int column) {
		if(matrix[row][column] == 1 || matrix[row][column] == -1)
			return false;
		System.out.println("size is "+ship_2_previous_coord.size());
//		if(ship_2_previous_coord.size() == 2) {
//			ship_2 = false;
//			ship_2_count--;
//			ship_2_previous_coord.clear();
//			return false;
//		}
		if (ship_2_previous_coord.size() > 0) {
			if (ship_2_previous_coord.get(0).y == row) {
				if (column == (ship_2_previous_coord.get(0).x + 1) || column == (ship_2_previous_coord.get(0).x - 1)) {
					ship_2_previous_coord.add(new Point(row, column));
					if(ship_2_previous_coord.size() == 2) {
						ship_2 = false;
						ship_2_count--;
						ship_2_previous_coord.clear();
					}
					return true;
				}
			}else if (ship_2_previous_coord.get(0).x == column) {
				if (row == (ship_2_previous_coord.get(0).y + 1) || row == (ship_2_previous_coord.get(0).y - 1)) {
					ship_2_previous_coord.add(new Point(row, column));
					if(ship_2_previous_coord.size() == 2) {
						ship_2 = false;
						ship_2_count--;
						ship_2_previous_coord.clear();
					}
					return true;
				}
			}
		}
		ship_2_previous_coord.add(new Point(row, column));
		return true;
	}
	
	public boolean ship_3_func(int row, int column) {
		boolean row_boolean = false;
		boolean column_boolean = false;
		if(matrix[row][column] == 1 || matrix[row][column] == -1)
			return false;
		if (ship_3_previous_coord.size() > 0) {
			if (ship_3_previous_coord.get(0).y == row) {
				row_boolean = true;
			} else {
				column_boolean = true;
			}
			if (row_boolean) {
				for (int i = 0; i < ship_3_previous_coord.size(); i++) {
					if (column == (ship_3_previous_coord.get(i).x + 1) || column == (ship_3_previous_coord.get(i).x - 1)) {
						ship_3_previous_coord.add(new Point(row, column));
						if(ship_3_previous_coord.size() == 3) {
							ship_3 = false;
							ship_3_count--;
							ship_3_previous_coord.clear();
						}
						return true;
					}
				}
			} else if (column_boolean){
				for (int i = 0; i < ship_3_previous_coord.size(); i++) {
					if (row == (ship_3_previous_coord.get(i).y + 1) || row == (ship_3_previous_coord.get(i).y - 1)) {
						ship_3_previous_coord.add(new Point(row, column));
						if(ship_3_previous_coord.size() == 3) {
							ship_3 = false;
							ship_3_count--;
							ship_3_previous_coord.clear();
						}
						return true;
					}
				}
			}else
				return false;
		}
		ship_3_previous_coord.add(new Point(row, column));
		return true;
	}
	
	public boolean ship_4_func(int row, int column) {
		if(matrix[row][column] == 1 || matrix[row][column] == -1)
			return false;
		if(ship_4_previous_coord.size() == 4) {
			ship_4 = false;
			ship_4_count--;
			ship_4_previous_coord.clear();
			return false;
		}
		if (ship_4_previous_coord.size() > 0) {
			if (ship_4_previous_coord.get(0).y == row) {
				for (int i = 0; i < ship_4_previous_coord.size(); i++) {
					if (column == (ship_4_previous_coord.get(i).x + 1) || column == (ship_4_previous_coord.get(i).x - 1)) {
						ship_4_previous_coord.add(new Point(row, column));
						return true;
					}
				}
			} else if (ship_4_previous_coord.get(0).x == column){
				for (int i = 0; i < ship_4_previous_coord.size(); i++) {
					if (row == (ship_4_previous_coord.get(i).y + 1) || row == (ship_4_previous_coord.get(i).y - 1)) {
						ship_4_previous_coord.add(new Point(row, column));
						return true;
					}
				}
			}else
				return false;
		}
		ship_4_previous_coord.add(new Point(row, column));
		return true;
	}
	
	public boolean ship_5_func(int row, int column) {
		if(matrix[row][column] == 1 || matrix[row][column] == -1)
			return false;
		System.out.println("inside ship_5_func");
		if (ship_5_previous_coord.size() > 0) {
			if (ship_5_previous_coord.get(0).y == row) {
				System.out.println("row =");
				for (int i = 0; i < ship_5_previous_coord.size(); i++) {
					if (column == (ship_5_previous_coord.get(i).x + 1) || column == (ship_5_previous_coord.get(i).x - 1)) {
						ship_5_previous_coord.add(new Point(row, column));
						if(ship_5_previous_coord.size() == 5) {
							ship_5 = false;
							ship_5_count--;
							ship_5_previous_coord.clear();
						}
						return true;
					}
				}
			} else if (ship_5_previous_coord.get(0).x == column){
				for (int i = 0; i < ship_5_previous_coord.size(); i++) {
					if (row == (ship_5_previous_coord.get(i).y + 1) || row == (ship_5_previous_coord.get(i).y - 1)) {
						ship_5_previous_coord.add(new Point(row, column));
						if(ship_5_previous_coord.size() == 5) {
							ship_5 = false;
							ship_5_count--;
							ship_5_previous_coord.clear();
						}
						return true;
					}
				}
			}else
				return false;
		}
		ship_5_previous_coord.add(new Point(row, column));
		return true;
	}
}

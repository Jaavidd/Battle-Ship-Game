package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;


public class MyPanel extends JPanel{
	EnemyPanel panelRight;
	Ship ship_obj = new Ship();
	GridLayout panelLayout;
	private JButton arr[][];
	int matrix_usr[][];
	boolean ship_2 = false;
	boolean ship_3 = false;
	boolean ship_4 = false;
	boolean ship_5 = false;
	
	int count_2 = 0;
	int count_3 = 0;
	int count_4 = 0;
	int count_5 = 0;
	
	int cell_counter = 0;
	
	MouseListener mouse;
	
	public MyPanel(EnemyPanel panelRight) {
		this.panelRight = (EnemyPanel)panelRight;
		mouse = new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = 0;
				int column = 0;
				for (int i = 0; i < arr.length; i++) 
					for (int j = 0; j < arr[0].length; j++) 
						if(arr[i][j] == e.getSource()) {
							row = i;
							column = j;
							break;	
						}
				if(ship_2) {
					if(ship_obj.ship_func(matrix_usr, 2, row, column)) {
						count_2++;
						matrix_usr[row][column] = 1;
						arr[row][column].setBackground(Color.RED);
						if (count_2 == 2) {
							ship_2 = false;
							count_2 = 0;
							cell_counter += 2;
						}
							
					}
				} else if(ship_3) {
					if(ship_obj.ship_func(matrix_usr, 3, row, column)) {
						count_3++;
						matrix_usr[row][column] = 1;
						arr[row][column].setBackground(Color.RED);
						if (count_3 == 3) {
							ship_3 = false;
							count_3 = 0;
							cell_counter += 3;
						}
							
					}
				} else if(ship_4) {
					if(ship_obj.ship_func(matrix_usr, 4, row, column)) {
						count_4++;
						matrix_usr[row][column] = 1;
						arr[row][column].setBackground(Color.RED);
						if (count_4 == 4) {
							ship_4 = false;
							count_4 = 0;
							cell_counter += 4;
						}
							
					}
				} else if(ship_5) {
					if(ship_obj.ship_func(matrix_usr, 5, row, column)) {
						count_5++;
						matrix_usr[row][column] = 1;
						arr[row][column].setBackground(Color.RED);
						if (count_5 == 5) {
							ship_5 = false;
							count_5 = 0;
							cell_counter += 5;
						}
							
					}
				}
				
				printM();
			}
		};
		panelLayout = new GridLayout(10,10);
		arr = new JButton[10][10];
		matrix_usr = new int[10][10];
		
		setSize(new Dimension(800, 800));
		setVisible(true);
		setLayout(panelLayout);
		fill_BUTTONS();
		
	}
	
	private  void fill_BUTTONS() {
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

	public void printM() {
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
	
	public void fill_PANEL_BOATS(int ship_type) {
		switch (ship_type) {
		case 2:
			ship_2 = true;
			break;
		case 3:
			ship_3 = true;
			break;
		case 4:
			ship_4 = true;
			break;
		default:
			ship_5 = true;
			break;
		}
	}
	
	
	public void panel_reset() {
		ship_obj.reset(matrix_usr, arr);
		if (ship_2) {
			count_2 = 0;
			ship_2 = false;
		}
		if (ship_3) {
			count_3 = 0;
			ship_3 = false;
		}
		if (ship_4) {
			count_4 = 0;
			ship_4 = false;
		}
		if (ship_5) {
			count_5 = 0;
			ship_5 = false;
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
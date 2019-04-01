package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

public class EnemyPanel extends JPanel{
	Random_Generator rand_gen = new Random_Generator();
	MyPanel panelLeft;
	GridLayout panelLayout;
	private JButton arr[][];
	int matrix_bot[][];
	int matrix_visited[][];
	MouseListener mouse;
	int counter = 18;
	
	
	
	public EnemyPanel(MyPanel panelLeft) {
		this.panelLeft = panelLeft;
		matrix_bot = rand_gen.getMatrix_bot();
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
				
				if (panelLeft.cell_counter == 17) {
					int row = 0;
					int column = 0;
					for (int i = 0; i < arr.length; i++) 
						for (int j = 0; j < arr[0].length; j++) 
							if(arr[i][j] == e.getSource()) {
								row = i;
								column = j;
								break;	
							}
					if (arr[row][column].getBackground() != Color.black || arr[row][column].getBackground() != Color.red) {
						if (matrix_bot[row][column] == 1) {
							arr[row][column].setBackground(Color.red);
							counter--;
						}else {
							arr[row][column].setBackground(Color.black);
							while(panelLeft.shoot(rand_point()));
						}
						System.out.println("counter is "+ counter);
						if (counter == 0) {
							System.out.println("User won");
							panelLeft.cell_counter = 16;
						}
					}
					
				}
				
			}
		};
		
		panelLayout = new GridLayout(10,10);
		arr = new JButton[10][10];
		
		matrix_visited = new int[10][10];
		setSize(new Dimension(800, 800));
		setVisible(true);
		setLayout(panelLayout);
		fill_BUTTONS();
		
		printM();
	}
	
	public void printM() {
		for (int i = 0; i < matrix_bot.length; i++) {
			for (int j = 0; j < matrix_bot[0].length; j++) {
				if (matrix_bot[i][j] == -1) 
					System.out.print("2 "); // instead of printing -1 print 2 (neglect sign, don't break matrix look)
				else
				System.out.print(matrix_bot[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
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
	
	
	public Point rand_point() {
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

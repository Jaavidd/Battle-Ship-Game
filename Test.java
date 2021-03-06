package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
	static JFrame frame;
	static MyPanel panelLeft;
	static EnemyPanel panelRight;
	static MenuBar panelBottom;
	static GridLayout frameLayout;
	
	public static void main(String[] args) {
		frame = new JFrame("BattleShip");
		
		panelLeft = new MyPanel(panelRight);
		panelRight = new EnemyPanel(panelLeft);
		panelBottom = new MenuBar(panelLeft);
		panelBottom.setSize(frame.getWidth(), frame.getHeight());
		
		frameLayout = new GridLayout(2, 1, 1, 1);
		frame.setSize(800, 800);
		frame.setLayout(frameLayout);
		frame.add(panelLeft);
		frame.add(panelRight);
		frame.add(panelBottom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}

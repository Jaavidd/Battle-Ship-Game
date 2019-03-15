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
	static MyPanel panelRight;
	static JPanel panelBottom;
//	static GridLayout panelLayout;
	static GridLayout frameLayout;
	
	public static void main(String[] args) {
		frame = new JFrame("BattleShip");
		
		panelLeft = new MyPanel();
		panelRight = new MyPanel();
		panelBottom = new JPanel();
		
		frameLayout = new GridLayout(2, 2, 1, 1);
		frame.setSize(800, 800);
		frame.setLayout(frameLayout);
		frame.add(panelLeft);
		frame.add(panelRight);
		frame.add(panelBottom);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
//		panelLeft.fill_PANEL_BOATS(2);
		panelLeft.fill_PANEL_BOATS(3);
		panelLeft.fill_PANEL_BOATS(4);
		panelLeft.fill_PANEL_BOATS(5);
	}
	
}

package main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBar extends JPanel{
	MyPanel panel;
	MouseListener listener;
	int ship_3_count = 2;
	JButton ship_2;
	JButton ship_3;
	JButton ship_4;
	JButton ship_5;
	JButton reset;
	int mode;
	
	
	public MenuBar(MyPanel panel) {
		this.panel = panel;
		
		listener = new MouseListener() {
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
				if (e.getSource() == ship_2) {
					mode = 2;
					panel.fill_PANEL_BOATS(mode);
					ship_2.removeMouseListener(listener);
				}
				if (e.getSource() == ship_3) {
					mode = 3;
					panel.fill_PANEL_BOATS(mode);
					if (ship_3_count == 1) {
						ship_3.removeMouseListener(listener);
					}else
						ship_3_count--;
				}
				if (e.getSource() == ship_4) {
					mode = 4;
					panel.fill_PANEL_BOATS(mode);
					ship_4.removeMouseListener(listener);
				}
				if (e.getSource() == ship_5) {
					mode = 5;
					panel.fill_PANEL_BOATS(mode);
					ship_5.removeMouseListener(listener);
				}
//				if (e.getSource() == reset) {
//					panel.panel_reset();
//					switch(mode) {
//						case 2:
//							System.out.println("2");
//							ship_2.addMouseListener(listener);
//							break;
//						case 3:
//							System.out.println("3");
//							if (ship_3_count == 0)
//								ship_3_count++;
//							else
//								ship_3.addMouseListener(listener);
//							break;
//						case 4:
//							System.out.println("4");
//							ship_4.addMouseListener(listener);
//							break;
//						case 5:
//							System.out.println("5");
//							ship_5.addMouseListener(listener);
//							break;
//					}
//				}
			}
		};

		ship_2 = new JButton("2");
		ship_3 = new JButton("3");
		ship_4 = new JButton("4");
		ship_5 = new JButton("5");
		reset = new JButton("Reset");
		ship_2.addMouseListener(listener);
		ship_3.addMouseListener(listener);
		ship_4.addMouseListener(listener);
		ship_5.addMouseListener(listener);
		reset.addMouseListener(listener);

		setLayout(new FlowLayout());
		setVisible(true);
		add(ship_2);
		add(ship_3);
		add(ship_4);
		add(ship_5);
		add(reset);
	}
}

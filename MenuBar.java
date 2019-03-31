package main;

import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuBar extends JPanel{
	MyPanel panel;
	MouseListener listener;
	int ship_2_count = 1;
	int ship_3_count = 2;
	int ship_4_count = 1;
	int ship_5_count = 1;
	JButton ship_2;
	JButton ship_3;
	JButton ship_4;
	JButton ship_5;
	JButton reset;
	int mode;
	
	
	// nujno ispravit kak predotvratit reset koqda uje vse zakoncilos
	
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
				if (panel.cell_counter != 17) {
					if (e.getSource() == ship_2) {
						if (ship_2_count > 0) {
							mode = 2;
							panel.fill_PANEL_BOATS(mode);
							ship_2_count--;
						}	
					}else if (e.getSource() == ship_3) {
						if (ship_3_count > 0) {
							mode = 3;
							panel.fill_PANEL_BOATS(mode);
							ship_3_count--;
						}
					}else if (e.getSource() == ship_4) {
						if (ship_4_count > 0) {
							mode = 4;
							panel.fill_PANEL_BOATS(mode);
							ship_4_count--;
						}
					}else if (e.getSource() == ship_5) {
						if (ship_5_count > 0) {
							mode = 5;
							panel.fill_PANEL_BOATS(mode);
							ship_5_count--;
						}
					}else if (e.getSource() == reset) {
						panel.panel_reset();
						switch(mode) {
							case 2:
								ship_2_count++;
								break;
							case 3:
								ship_3_count++;
								break;
							case 4:
								ship_4_count++;
								break;
							case 5:
								ship_5_count++;
								break;
						}
					}
				}
				
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

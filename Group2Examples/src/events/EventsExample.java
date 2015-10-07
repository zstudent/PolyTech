package events;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class EventsExample {
	
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Events Example");
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		
		panel.setPreferredSize(new Dimension(400,400));
		
		JLabel label = new JLabel("Hello, world!");
		
		panel.add(label);
		
		JButton button = new JButton("Click me!");
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("clicked!");
				
				label.setText("clicked");
			}
		});
		
		panel.add(button);
		
		frame.add(panel);
		
		frame.pack();
		
	}

}

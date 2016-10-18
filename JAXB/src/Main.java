import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.setBounds(100, 100, 511, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("MARSHALLING (OBJECTS --> XML)");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				marshall m= new marshall();
				m.main(null);
			    frame.setVisible(false);
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setBounds(81, 64, 303, 55);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("UNMARSHALLING (XML --> OBJECTS)");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				unmarshall um= new unmarshall();
				um.main(null);
			    frame.setVisible(false);
			}
		});
		btnNewButton_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		btnNewButton_1.setBounds(81, 159, 303, 55);
		frame.getContentPane().add(btnNewButton_1);
	}
}

import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;


public class unmarshall {

	private JFrame frame;
	private JTextField text;
	JFileChooser chooser=new JFileChooser();
	String choosertitle;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					unmarshall window = new unmarshall();
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
	public unmarshall() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 14));
		frame.setBounds(100, 100, 600, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSelectThe = new JLabel("* Select the Xml File :");
		lblSelectThe.setForeground(new Color(0, 128, 128));
		lblSelectThe.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lblSelectThe.setBounds(26, 61, 163, 16);
		frame.getContentPane().add(lblSelectThe);
		
		text = new JTextField();
		text.setFont(new Font("Tahoma", Font.PLAIN, 14));
		text.setBounds(26, 102, 344, 34);
		frame.getContentPane().add(text);
		text.setColumns(10);
		
		
		
		JButton btnNewButton = new JButton("BROWSE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				chooser = new JFileChooser(); 
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle(choosertitle);
			    chooser.setFileSelectionMode(JFileChooser.APPROVE_OPTION);
			    //
			    // disable the "All files" option.
			    //
			    chooser.setAcceptAllFileFilterUsed(true);
			    //    
			    if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) 
			    { 
			     text.setText(chooser.getSelectedFile().toString());
			      }
			    else {
			      System.out.println("No Selection ");
			      }
			}
		});
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(414, 101, 120, 34);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(new Color(0, 128, 128));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblId.setBounds(33, 165, 56, 16);
		frame.getContentPane().add(lblId);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(new Color(0, 128, 128));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(33, 208, 56, 16);
		frame.getContentPane().add(lblName);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setForeground(new Color(0, 128, 128));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAge.setBounds(35, 250, 56, 23);
		frame.getContentPane().add(lblAge);
		
		JLabel lblid = new JLabel("");
		lblid.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblid.setBounds(112, 166, 56, 23);
		frame.getContentPane().add(lblid);
		
		JLabel lblname = new JLabel("");
		lblname.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblname.setBounds(112, 209, 56, 23);
		frame.getContentPane().add(lblname);
		
		JLabel lblage = new JLabel("");
		lblage.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblage.setBounds(112, 251, 56, 23);
		frame.getContentPane().add(lblage);
		
		JButton btnNewButton_1 = new JButton("Upload the Xml File");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  try {
					  
					  String path=text.getText();
						path = path.replace("\\", "\\\\");
						System.out.println(path);
						
			            JAXBContext context = JAXBContext.newInstance(Customer.class);
			            Unmarshaller un = context.createUnmarshaller();
			            Customer customer = (Customer) un.unmarshal(new File(path));
			            
			             lblid.setText(Integer.toString(customer.getId()));
			             lblname.setText(customer.getName());
			             lblage.setText(Integer.toString(customer.getAge()));
			        } catch (JAXBException e) {
			            e.printStackTrace();
			        }
				
			}
		});
		btnNewButton_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(148, 287, 274, 34);
		frame.getContentPane().add(btnNewButton_1);
		
		
		
		Icon a=new ImageIcon(getClass().getResource("bc.png"));
		JButton btnBack = new JButton("",a);
		btnBack.setBounds(0, 0, 56, 48);
		frame.getContentPane().add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main m=new Main();
				m.main(null);
				frame.setVisible(false);
			}
		});
		
		btnBack.setOpaque(false);
		btnBack.setBorder(null);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
	}
}

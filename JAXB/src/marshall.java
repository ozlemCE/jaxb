import java.io.File;

import javax.swing.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.awt.event.*;
import java.awt.*;
import java.util.*;
import java.io.*;



public class marshall {
	
	JFileChooser chooser;
    String choosertitle;

	private JFrame frame;
	private JTextField text;
	private JTextField textName;
	private JTextField textAge;
	private JTextField textId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marshall window = new marshall();
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
	public marshall() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(245, 255, 250));
		frame.setBounds(100, 100, 613, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lbl = new JLabel("* Select the Export Destination of Xml File :");
		lbl.setForeground(new Color(0, 128, 128));
		lbl.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		lbl.setBounds(82, 13, 367, 27);
		frame.getContentPane().add(lbl);
		
		text = new JTextField();
		text.setFont(new Font("Tahoma", Font.PLAIN, 15));
		text.setBounds(82, 53, 367, 37);
		frame.getContentPane().add(text);
		text.setColumns(10);
		
		JButton btnNewButton = new JButton("BROWSE");
		btnNewButton.setForeground(new Color(0, 128, 128));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				chooser = new JFileChooser(); 
			    chooser.setCurrentDirectory(new java.io.File("."));
			    chooser.setDialogTitle(choosertitle);
			    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			    //
			    // disable the "All files" option.
			    //
			    chooser.setAcceptAllFileFilterUsed(false);
			    //    
			    if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) 
			    { 
			     text.setText(chooser.getSelectedFile().toString());
			      }
			    else {
			      System.out.println("No Selection ");
			      }
			}
		});
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(473, 53, 110, 37);
		frame.getContentPane().add(btnNewButton);
		
		
		
		JButton btnNewButton_1 = new JButton("Create the Xml File");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 try {
					 
					 Customer customer = new Customer();
						customer.setName(textName.getText().toString());
						customer.setAge(Integer.parseInt(textAge.getText()));
						customer.setId(Integer.parseInt(textId.getText()));

						String path=text.getText();
						path = path.replace("\\", "\\\\");
						System.out.println(path);
					   File file = new File(path+"\\file.xml");
					   JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
					   Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

					   // output pretty printed
					   jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

					   jaxbMarshaller.marshal(customer, file);
					   jaxbMarshaller.marshal(customer, System.out);

					   JOptionPane.showMessageDialog(null,"Xml File Created");
					   
					   textId.setText("");
					   textName.setText("");
					   textAge.setText("");
					   
					        } catch (JAXBException e) {
					   e.printStackTrace();
					        }
			}
		});
		btnNewButton_1.setForeground(new Color(0, 128, 128));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBounds(153, 261, 236, 45);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblName = new JLabel("NAME :");
		lblName.setForeground(new Color(0, 128, 128));
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(12, 160, 60, 37);
		frame.getContentPane().add(lblName);
		
		JLabel lblNewLabel = new JLabel("AGE :");
		lblNewLabel.setForeground(new Color(0, 128, 128));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(12, 210, 60, 37);
		frame.getContentPane().add(lblNewLabel);
		
		textName = new JTextField();
		textName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textName.setBounds(84, 165, 365, 32);
		frame.getContentPane().add(textName);
		textName.setColumns(10);
		
		textAge = new JTextField();
		textAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAge.setBounds(84, 210, 365, 32);
		frame.getContentPane().add(textAge);
		textAge.setColumns(10);
		
		textId = new JTextField();
		textId.setBounds(84, 120, 365, 32);
		frame.getContentPane().add(textId);
		textId.setColumns(10);
		
		JLabel lblId = new JLabel("ID :");
		lblId.setForeground(new Color(0, 128, 128));
		lblId.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblId.setBounds(12, 122, 60, 27);
		frame.getContentPane().add(lblId);
		
		Icon a=new ImageIcon(getClass().getResource("bc.png"));
		JButton btnBack = new JButton("",a);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Main m=new Main();
				m.main(null);
				frame.setVisible(false);
			}
		});
		btnBack.setBounds(12, 13, 49, 55);
		frame.getContentPane().add(btnBack);
		btnBack.setOpaque(false);
		btnBack.setBorder(null);
		btnBack.setBorderPainted(false);
		btnBack.setContentAreaFilled(false);
	
	}
}

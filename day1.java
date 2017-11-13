import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class day1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					day1 window = new day1();
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
	public day1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 493, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 198, 293);
		frame.getContentPane().add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(197, 0, 280, 293);
		frame.getContentPane().add(panel_1);
		JButton  Text_to_Excel= new JButton("Text to Excel");
		Text_to_Excel.setBounds(34, 25, 110, 23);
		Text_to_Excel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				panel_1.removeAll();
				panel_1.validate();
				JButton browse = new JButton("Browse");
				browse.setBounds(34, 25, 110, 23);
				browse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fc = new JFileChooser();
						fc.setCurrentDirectory(new java.io.File(".")); // start at application current directory
						fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						int returnVal = fc.showSaveDialog(fc);
						if(returnVal == JFileChooser.APPROVE_OPTION) {
						    File yourFolder = fc.getSelectedFile();
						}
					}
				});
				panel_1.add(browse);
				
				panel_1.validate();
			}
		});
		panel.setLayout(null);
		panel.add(Text_to_Excel);
		
		JButton Excel_to_Text = new JButton("Excel to Text");
		Excel_to_Text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.validate();
				JButton browse = new JButton("Browse");
				browse.setBounds(34, 25, 110, 23);
				browse.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JFileChooser fc = new JFileChooser();
						fc.setCurrentDirectory(new java.io.File(".")); // start at application current directory
						fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						int returnVal = fc.showSaveDialog(fc);
						if(returnVal == JFileChooser.APPROVE_OPTION) {
						    File yourFolder = fc.getSelectedFile();
						    JComboBox comboBox = new JComboBox();
							comboBox.setBounds(66, 130, 67, 20);
							panel_1.add(comboBox);
							panel_1.validate();
						}
					}
				});
				
				panel_1.add(browse);
				panel_1.validate();
			}
		});
		Excel_to_Text.setBounds(34, 75, 110, 23);
		panel.add(Excel_to_Text);
		
		
		
		
	}
}

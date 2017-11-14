import java.awt.EventQueue;
import java.awt.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
//import org.apache.commons.io.FileUtils;
public class day1 implements ActionListener{

	private JFrame frame;
	public JPanel panel,panel_1;
	public JButton Text_to_Excel,Excel_to_Text;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
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
	

	public void actionPerformed(ActionEvent e) {
		try {
			panel_1.removeAll();
			panel_1.validate();
			JButton browse = new JButton("Browse");
			browse.setBounds(34, 25, 110, 23);
			JComboBox<String> comboBox = new JComboBox<String>();
			JTextPane textPane = new JTextPane();
			JTextPane textPane1= new JTextPane();
			JTextField textField = new JTextField();
			JButton submit = new JButton("Submit");
			JLabel OutputFileName = new JLabel("output file name");
			JButton browseout = new JButton("Browse Output Folder");
			browseout.setBounds(34, 25, 110, 23);
			comboBox.setBounds(34, 25, 110, 23);
			textPane.setBounds(34, 25, 110, 23);
			browse.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					comboBox.removeAllItems();
					JFileChooser fc = new JFileChooser();
					fc.setCurrentDirectory(new java.io.File(".")); // start at application current directory
					fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
					int returnVal = fc.showSaveDialog(fc);
					if(returnVal == JFileChooser.APPROVE_OPTION) {
					    File yourFolder = fc.getSelectedFile();
					    textPane.setText(yourFolder.getPath());
						ArrayList<String> filesname = new ArrayList<String>();
						
						 for (File f : yourFolder.listFiles()) {
							 if (f.getName().endsWith((".txt"))) {
							      filesname.add(f.getPath());
							    }
						 }
						for( String obj : filesname) {
							comboBox.addItem(obj);
						}
						if (comboBox.getSelectedItem().toString()!="")
							{
								File f=new File(comboBox.getSelectedItem().toString());
								browseout.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										JFileChooser fc = new JFileChooser();
										fc.setCurrentDirectory(new java.io.File(".")); // start at application current directory
										fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
										int returnVal = fc.showSaveDialog(fc);
										if(returnVal == JFileChooser.APPROVE_OPTION) {
										    File yourFolder = fc.getSelectedFile();
										    textPane1.setText(yourFolder.getPath());
											
								}
								}
								});
					}
				}
			}
			});
			panel_1.add(browse);
			panel_1.add(textPane);
			panel_1.add(comboBox);
			panel_1.add(browseout);
			panel_1.add(textPane1);
			panel_1.add(OutputFileName);
			panel_1.add(textField);
			panel_1.add(submit);
			panel_1.validate();
			}catch(Exception ex) {}
		}
	
	public day1() {
		frame = new JFrame();
		frame.setBounds(100, 100, 493, 332);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationByPlatform(true);
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 198, 293);
		frame.getContentPane().add(panel);
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(197, 0, 280, 293);
		  panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		 // panel_1.setMaximumSize( panel_1.getPreferredSize() );
		//panel_1.setLayout(null);
		frame.getContentPane().add(panel_1);
		Text_to_Excel= new JButton("Text to Excel");
		Text_to_Excel.setBounds(34, 25, 110, 23);
		Text_to_Excel.addActionListener(this);
		panel.setLayout(null);
		panel.add(Text_to_Excel);
		
		Excel_to_Text = new JButton("Excel to Text");
		Excel_to_Text.addActionListener(this);
		Excel_to_Text.setBounds(34, 75, 110, 23);
		panel.add(Excel_to_Text);	
		
	}
}

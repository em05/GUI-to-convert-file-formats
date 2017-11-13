package day1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 573, 363);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel p1 = new JPanel();
		p1.setBorder(new LineBorder(new Color(0, 0, 0)));
		p1.setBounds(0, 0, 194, 324);
		frame.getContentPane().add(p1);
		p1.setLayout(null);
		JPanel p2 = new JPanel();
		p2.setBorder(new LineBorder(new Color(0, 0, 0)));
		p2.setBounds(194, 0, 363, 324);
		frame.getContentPane().add(p2);
		p2.setLayout(null);
		JButton btnTextToExcel = new JButton("Text to Excel");
		btnTextToExcel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//p2.revalidate();
				JButton browse = new JButton("Browse");
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
				p2.add(browse);
				p2.revalidate();
			}
		});
		btnTextToExcel.setBounds(31, 23, 119, 23);
		p1.add(btnTextToExcel);
		
		JButton btnExcel_to_Text = new JButton("Excel to Text");
		btnExcel_to_Text.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JButton browse = new JButton("Browse");
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
				p2.add(browse);
				p2.revalidate();
				p2.repaint();
			}
		});
		btnExcel_to_Text.setBounds(31, 67, 119, 23);
		p1.add(btnExcel_to_Text);
		
		
	}
}

package com.isd.youdu;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CopyTo {

	private JFrame frame;
	/**
	 * @wbp.nonvisual location=57,17
	 */
	private final JLabel TopText = new JLabel("离散型关联函数界面");
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopyTo window = new CopyTo();
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
	public CopyTo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u4F60\u9700\u8981\u7684\u5173\u8054\u51FD\u6570\u3001");
		label.setBounds(10, 10, 156, 39);
		frame.getContentPane().add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(190, 19, 32, 21);
		frame.getContentPane().add(comboBox);
		
		textField = new JTextField();
		textField.setBounds(260, 82, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u9700\u8981\u67E5\u8BE2\u548C\u4FEE\u6539\u7684\u5173\u8054\u51FD\u6570");
		label_1.setBounds(10, 59, 156, 66);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("\u786E\u8BA4\u5173\u8054\u51FD\u6570");
		button.setBounds(304, 55, 120, 23);
		frame.getContentPane().add(button);
		
		JButton btnNewButton = new JButton("确认编辑查询的关联函数");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(247, 112, 177, 23);
		frame.getContentPane().add(btnNewButton);
		
		textField_1 = new JTextField();
		textField_1.setBounds(304, 19, 66, 21);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u7C7B\u578B\uFF1A");
		label_2.setBounds(256, 22, 54, 15);
		frame.getContentPane().add(label_2);
	}
}

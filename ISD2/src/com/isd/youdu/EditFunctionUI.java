package com.isd.youdu;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
/**
 * 添加离散关联函数的界面
 * @author shamaowei
 *
 */
public class EditFunctionUI {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditFunctionUI window = new EditFunctionUI();
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
	public EditFunctionUI() {
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
		
		JLabel label = new JLabel("\u540D\u79F0:");
		label.setBounds(10, 10, 54, 15);
		frame.getContentPane().add(label);
		
		textField = new JTextField();
		textField.setBounds(60, 7, 66, 21);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("类型:");
		label_1.setBounds(162, 10, 54, 15);
		frame.getContentPane().add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(220, 7, 32, 21);
		frame.getContentPane().add(comboBox);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setBounds(312, 6, 93, 23);
		frame.getContentPane().add(btnNewButton);

		JScrollPane scrollpane = this.gettable();
		frame.getContentPane().add(scrollpane);
		
	}
	/**
	 * 显示表格供用户填写信息
	 * @return JScrollPane 返回被滚动条封装的表格
	 */
public JScrollPane gettable(){
	final Object[] columnNames = {"k值", "大于", "小于等于"}; //列名最好用final修饰
	Object[][] rowData = new Object[10][10];
	JTable table = new JTable(rowData,columnNames);
	JScrollPane scrollpane = new JScrollPane(table);
	scrollpane.setBounds(0,36,434,226);
	
	return scrollpane;
}
}

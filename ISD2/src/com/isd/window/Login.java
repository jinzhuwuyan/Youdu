package com.isd.window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Login {

	private JFrame frame;
	private JTextField jtf_name;
	private JTextField jtf_password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
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

		JButton jb_login = new JButton("\u767B\u5F55");
		jb_login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ApplicationWindow(jtf_name.getText().trim());
				Login.this.frame.dispose();
			}
		});
		jb_login.setBounds(225, 163, 68, 23);
		frame.getContentPane().add(jb_login);

		JLabel jl_name = new JLabel("\u7528\u6237\u540D");
		jl_name.setHorizontalAlignment(SwingConstants.CENTER);
		jl_name.setBounds(115, 70, 54, 15);
		frame.getContentPane().add(jl_name);

		jtf_name = new JTextField();
		jtf_name.setBounds(200, 67, 93, 21);
		frame.getContentPane().add(jtf_name);
		jtf_name.setColumns(10);

		jtf_password = new JTextField();
		jtf_password.setBounds(200, 113, 93, 21);
		frame.getContentPane().add(jtf_password);
		jtf_password.setColumns(10);

		JLabel jl_password = new JLabel("\u5BC6\u7801");
		jl_password.setHorizontalAlignment(SwingConstants.CENTER);
		jl_password.setBounds(115, 116, 54, 15);
		frame.getContentPane().add(jl_password);

		JButton jb_regist = new JButton("\u6CE8\u518C");
		jb_regist.setBounds(112, 163, 71, 23);
		frame.getContentPane().add(jb_regist);
	}
}

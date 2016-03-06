package com.isd.window;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.isd.bean.ElementBean;
import com.isd.constant.Constant;

public class AddElementWindow {
	private ElementBean eb;
	private JFrame frame;
	private JTextField jtf_character1;
	private JTextField jtf_goalName;
	private JTextField jtf_character2;
	private JTextField jtf_value1;
	private JTextField jtf_value2;
	private JTextField jtf_character3;
	private JTextField jtf_value3;
	JLabel jl_EGname;
	JLabel jl_EGCondition;
	private JButton jb_addCaracter;
	private JLabel jl_EGvalue;
	private JButton jb_enter;
	private JButton jb_clear;
	private JComboBox jcb_type3;
	private JComboBox jcb_type1;
	private JComboBox jcb_type2;
	private JComboBox jcb_precursor;
	private HashMap<String, String> names;
	private WindowInterface wi;
	private int userId;
	private int doWhat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// AddEGWindow window = new AddEGWindow(new
					// ElementServise(),
					// 0, null);
					// window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AddElementWindow(WindowInterface appWindow, int doWhat, int userId,
			HashMap<String, String> names2) {
		this.doWhat = doWhat;
		this.names = names2;
		this.wi = appWindow;
		this.userId = userId;
		initialize();
		initListener();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("\u8BF7\u8F93\u5165\u60A8\u7684\u76EE\u6807\u57FA\u5143\u4FE1\u606F");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		jl_EGname = new JLabel("\u57FA\u5143\u540D\u5B57");
		jl_EGname.setBounds(42, 22, 58, 15);
		frame.getContentPane().add(jl_EGname);

		jl_EGCondition = new JLabel("\u5C5E\u6027");
		jl_EGCondition.setBounds(71, 72, 29, 15);
		frame.getContentPane().add(jl_EGCondition);

		jtf_character1 = new JTextField();
		jtf_character1.setBounds(39, 97, 92, 21);
		frame.getContentPane().add(jtf_character1);
		jtf_character1.setColumns(10);

		jtf_goalName = new JTextField();
		jtf_goalName.setBounds(110, 19, 92, 21);
		frame.getContentPane().add(jtf_goalName);
		jtf_goalName.setColumns(10);

		jb_addCaracter = new JButton("\u6DFB\u52A0\u5C5E\u6027");
		jb_addCaracter.setBounds(178, 215, 92, 23);
		frame.getContentPane().add(jb_addCaracter);

		jl_EGvalue = new JLabel("\u503C");
		jl_EGvalue.setBounds(216, 72, 18, 15);
		frame.getContentPane().add(jl_EGvalue);

		jtf_character2 = new JTextField();
		jtf_character2.setColumns(10);
		jtf_character2.setBounds(39, 128, 92, 21);
		frame.getContentPane().add(jtf_character2);

		jtf_value1 = new JTextField();
		jtf_value1.setColumns(10);
		jtf_value1.setBounds(178, 97, 92, 21);
		frame.getContentPane().add(jtf_value1);

		jtf_value2 = new JTextField();
		jtf_value2.setColumns(10);
		jtf_value2.setBounds(178, 128, 92, 21);
		frame.getContentPane().add(jtf_value2);

		jb_enter = new JButton("\u786E\u8BA4");
		jb_enter.setBounds(354, 215, 70, 23);
		jb_enter.setActionCommand(String.valueOf(Constant.COMMOND_ADDEC));

		frame.getContentPane().add(jb_enter);

		jb_clear = new JButton("\u6E05\u9664");

		jb_clear.setBounds(280, 215, 64, 23);
		frame.getContentPane().add(jb_clear);

		JLabel lblNewLabel = new JLabel("\u7C7B\u578B");
		lblNewLabel.setBounds(329, 72, 29, 15);
		frame.getContentPane().add(lblNewLabel);

		jcb_type1 = new JComboBox();
		jcb_type1.setBounds(304, 97, 78, 21);
		frame.getContentPane().add(jcb_type1);

		jcb_type2 = new JComboBox();
		jcb_type2.setBounds(304, 128, 78, 21);
		frame.getContentPane().add(jcb_type2);

		jtf_character3 = new JTextField();
		jtf_character3.setColumns(10);
		jtf_character3.setBounds(39, 159, 92, 21);
		frame.getContentPane().add(jtf_character3);

		jtf_value3 = new JTextField();
		jtf_value3.setColumns(10);
		jtf_value3.setBounds(178, 159, 92, 21);
		frame.getContentPane().add(jtf_value3);

		jcb_type3 = new JComboBox();
		jcb_type3.setBounds(304, 159, 78, 21);
		frame.getContentPane().add(jcb_type3);

		JLabel lblNewLabel_1 = new JLabel("\u524D\u9A71");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(265, 22, 54, 15);
		frame.getContentPane().add(lblNewLabel_1);

		jcb_precursor = new JComboBox(names.keySet().toArray());
		jcb_precursor.setBounds(329, 19, 81, 21);
		frame.getContentPane().add(jcb_precursor);
		frame.setVisible(true);
	}

	private void initListener() {
		jb_enter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				eb = new ElementBean();
				eb.setHostId(userId);
				HashMap<String, String[]> CandV = new HashMap<String, String[]>();
				CandV.put(jtf_character1.getText().trim(), new String[] {
						jtf_value1.getText().trim(), " " });
				CandV.put(jtf_character2.getText().trim(), new String[] {
						jtf_value2.getText().trim(), " " });
				CandV.put(jtf_character3.getText().trim(), new String[] {
						jtf_value3.getText().trim(), " " });
				eb.setName(jtf_goalName.getText().trim());
				eb.setCandV(CandV);
				String precursorName = jcb_precursor.getSelectedItem()
						.toString().trim();
				if (null == precursorName || precursorName.equals("null")) {
					eb.setPrecursorName("null");
					eb.setPrecursorId("-1");
				} else {
					eb.setPrecursorName(precursorName);
					eb.setPrecursorId(names.get(precursorName));
				}
				wi.callBack(doWhat, eb);
				AddElementWindow.this.frame.dispose();
			}
		});
		jb_clear.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
		jb_addCaracter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

			}
		});
	}
}

package com.isd.window;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.isd.bean.BeliefBean;
import com.isd.bean.ElementBean;
import com.isd.bean.ElementNode;
import com.isd.bean.ElementTree;
import com.isd.constant.Constant;
import com.isd.servise.ElementServise;

public class ApplicationWindow implements WindowInterface {
	// 条件基元序列
	public ElementTree conditionTree = null;
	// 目标基元序列
	public ElementTree goalTree = null;
	// 结果设置标志
	private boolean ResultSeted = false;

	String userName = null;

	private JFrame frmSd;
	private ElementBean result;
	private JButton jb_addEG;
	private JButton jb_addEC;
	private JButton jb_save;
	private JButton jb_query;
	private JButton jb_goalVisuable;
	private JButton jb_conditionVisuable;
	private JButton jb_deleEC;
	private JButton jb_deleEG;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow("luohang");
					window.frmSd.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */

	public ApplicationWindow(String userName) {
		// this.userName = userName;
		this.userName = "luohang";
		conditionTree = new ElementTree();
		goalTree = new ElementTree();
		initElement();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSd = new JFrame();
		frmSd.getContentPane().setBackground(Color.WHITE);
		frmSd.setTitle("\u667A\u80FD\u52A9\u624B");
		frmSd.setBounds(100, 100, 497, 303);
		frmSd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSd.getContentPane().setLayout(null);

		jb_addEG = new JButton("添加目标");
		jb_addEG.setBounds(10, 10, 110, 23);
		frmSd.getContentPane().add(jb_addEG);

		jb_addEC = new JButton("添加条件");

		jb_addEC.setBounds(10, 43, 110, 23);
		frmSd.getContentPane().add(jb_addEC);

		jb_save = new JButton("保存");

		jb_save.setBounds(126, 76, 124, 23);
		frmSd.getContentPane().add(jb_save);

		jb_deleEG = new JButton("\u5220\u9664\u76EE\u6807\u57FA\u5143");
		jb_deleEG.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
			}
		});
		jb_deleEG.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		jb_deleEG.setBounds(126, 10, 124, 23);
		frmSd.getContentPane().add(jb_deleEG);
		jb_query = new JButton("\u67E5\u8BE2");
		jb_query.setBounds(10, 76, 110, 23);
		frmSd.getContentPane().add(jb_query);

		jb_goalVisuable = new JButton("\u76EE\u6807\u53EF\u89C6\u5316");
		jb_goalVisuable.setBounds(260, 10, 106, 23);
		frmSd.getContentPane().add(jb_goalVisuable);

		jb_conditionVisuable = new JButton("\u6761\u4EF6\u53EF\u89C6\u5316");
		jb_conditionVisuable.setBounds(260, 43, 106, 23);
		frmSd.getContentPane().add(jb_conditionVisuable);

		jb_deleEC = new JButton("\u5220\u9664\u6761\u4EF6\u57FA\u5143");
		jb_deleEC.setBounds(126, 43, 124, 23);
		frmSd.getContentPane().add(jb_deleEC);
		initedListener();
		frmSd.setVisible(true);
	}

	private void initedListener() {
		jb_addEC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				new AddElementWindow(ApplicationWindow.this,
						Constant.COMMOND_ADDEC, 1, conditionTree
								.getNodeNameAndId());
			}
		});
		jb_addEG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new AddElementWindow(ApplicationWindow.this,
						Constant.COMMOND_ADDEG, 1, goalTree.getNodeNameAndId());
			}
		});
		jb_save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ElementServise appServise = new ElementServise();
				appServise.saveEC(userName, conditionTree.getAllChildNode());
				appServise.saveEG(userName, goalTree.getAllChildNode());
			}
		});
		jb_query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (ElementNode b : goalTree.getAllChildNode()) {
					System.out
							.println("基元名：" + b.getInfo().getName()
									+ "   hostId:  " + b.getInfo().getHostId()
									+ "   precuror:  "
									+ b.getInfo().getPrecursorName());
					for (Entry<String, String[]> e2 : b.getInfo().getCandV()
							.entrySet()) {
						System.out.println("基元属性名：" + e2.getKey() + "   基元属性值："
								+ e2.getValue()[0] + "    基元属性类型："
								+ e2.getValue()[1]);
					}
				}
				System.out.println("--------------");
			}
		});
		jb_goalVisuable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ElementVisuableWindow(goalTree);
			}
		});
		jb_conditionVisuable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ElementVisuableWindow(conditionTree);
			}
		});
		jb_deleEC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(frmSd,
						"请输入要删除条件基元名字", "删除条件基元",
						JOptionPane.INFORMATION_MESSAGE);
				if (null != name && name.trim().length() != 0) {
					if (conditionTree.deleteElementNode(name, true)) {
						JOptionPane.showMessageDialog(frmSd, "删除成功");
					} else {
						JOptionPane.showMessageDialog(frmSd, "删除失败");
					}
				}
			}
		});
		jb_deleEG.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = JOptionPane.showInputDialog(frmSd,
						"请输入要删除目标基元名字", "删除目标基元",
						JOptionPane.INFORMATION_MESSAGE);
				if (null != name && name.trim().length() != 0) {
					if (goalTree.deleteElementNode(name, true)) {
						JOptionPane.showMessageDialog(frmSd, "删除成功");
					} else {
						JOptionPane.showMessageDialog(frmSd, "删除失败");
					}
				}
			}
		});
	}
	
	
	//条件列表化，删除后保存至数据库

	
	
	public void initElement() {
		ElementServise es = new ElementServise();
		ArrayList<BeliefBean> egs = es.getAllEG();
		ArrayList<BeliefBean> ecs = es.getAllEC();
		if (egs != null) {
			for (BeliefBean bb : egs) {
				goalTree.addElementNode(new ElementNode(bb));
			}
		}
		if (ecs != null) {
			for (BeliefBean bb : ecs) {
				conditionTree.addElementNode(new ElementNode(bb));
			}
		}
	}

	class GetCThread extends Thread {
		@Override
		public void run() {
			while (!ResultSeted) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			conditionTree.addElementNode(new ElementNode(result));
			ResultSeted = false;
		}
	}

	class getGThread extends Thread {
		@Override
		public void run() {
			while (!ResultSeted) {
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			goalTree.addElementNode(new ElementNode(result));
			ResultSeted = false;
		}
	}

	@Override
	public void callBack(int doWhat, ElementBean eb) {
		switch (doWhat) {
		case Constant.COMMOND_ADDEC:
			conditionTree.addElementNode(new ElementNode(eb));
			break;
		case Constant.COMMOND_ADDEG:
			goalTree.addElementNode(new ElementNode(eb));
			break;
		default:
			break;
		}

	}
}

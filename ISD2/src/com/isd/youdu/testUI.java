package com.isd.youdu;
/**
 * 基元选择框
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
public class testUI implements ListSelectionListener {
	JList list = null;
	JLabel label = null;
	String[] s = { "美国", "中国", "英国", "法国", "意大利", "澳洲", "韩国" };
	public testUI() {
		JFrame f = new JFrame("JList");
		Container contentPane = f.getContentPane();
		contentPane.setLayout(new BorderLayout());
		label = new JLabel();
		list = new JList(s);
		list.setVisibleRowCount(5); // 设定列表方框的可见栏数
		list.setBorder(BorderFactory
				.createTitledBorder("您最喜欢到哪个国家玩呢？"));
		list.addListSelectionListener(this);
		contentPane.add(label, BorderLayout.NORTH);
		// 给列表方框添加滚动栏
		contentPane.add(new JScrollPane(list), BorderLayout.CENTER);
		f.pack();
		f.show();
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	public void valueChanged(ListSelectionEvent e) {
		int tmp = 0;
		String stmp = "您目前选取：";
        //利用JList类所提供的getSelectedIndices()方法可得到用户所选取的所有项目
		int[] index = list.getSelectedIndices();
        //index值，这些index值由一个int array返回.
		for (int i = 0; i < index.length; i++)
		{
			tmp = index[i];
			stmp = stmp + s[tmp] + "  ";
		}
		label.setText(stmp);
	}
	public static void main(String args[]) {
		new testUI();
	}
}
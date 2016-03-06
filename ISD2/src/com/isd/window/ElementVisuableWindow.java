package com.isd.window;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.isd.bean.ElementBean;
import com.isd.bean.ElementTree;

public class ElementVisuableWindow {
	ArrayList<Collection<ElementBean>> el = null;
	HashMap<String, Integer[]> coordinate = null;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElementVisuableWindow window = new ElementVisuableWindow(
							null);
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
	public ElementVisuableWindow(ElementTree et) {
		initialize();
		if (et != null) {
			el = et.getAllChildNodeByLevel();
			coordinate = new HashMap<String, Integer[]>();
			frame.getContentPane().add(new mypanel(el));
			frame.setVisible(true);
		}
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

	class mypanel extends JPanel {
		ArrayList<Collection<ElementBean>> eba = null;

		public mypanel(ArrayList<Collection<ElementBean>> eba) {
			this.eba = eba;
		}

		@Override
		public void paint(Graphics g) {
			// TODO Auto-generated method stub
			super.paint(g);
			Font myFont = new Font("华文新魏", Font.BOLD, 10);
			FontMetrics fm = new FontMetrics(myFont) {
			};
			for (int k = 0; k < el.size(); k++) {
				int i = 0;
				for (ElementBean eb : el.get(k)) {
					// 获取字符串的宽度
					Rectangle2D bounds = fm.getStringBounds(eb.getName(), null);
					int width = (int) bounds.getWidth();
					int height = (int) bounds.getHeight();
					g.setFont(myFont);
					g.drawString(eb.getName(), 21 + 60 * k, 70 + 25 * i);
					// 保存坐标
					coordinate.put(eb.getUuid(), new Integer[] {
							21 + 60 * k + width, 70 + 25 * i });
					// 画线
					if (eb.getPrecursorId() != "-1") {
						g.drawLine(coordinate.get(eb.getPrecursorId())[0],
								coordinate.get(eb.getPrecursorId())[1],
								21 + 60 * k, 70 + 25 * i);
					}
					i++;
				}
			}

		}
	}
}

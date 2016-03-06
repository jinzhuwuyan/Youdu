package com.isd.servise;

import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import com.isd.bean.BeliefBean;
import com.isd.bean.ElementBean;
import com.isd.bean.ElementNode;
import com.isd.window.ApplicationWindow;

/**
 * 
 * @author luohang
 * 
 */
public class ElementServise {
	String userName;

	public ElementServise() {
		super();
	}

	public ElementServise(String userName) {
		super();
		this.userName = userName;
	}

	public void deleteEG() {
	}

	public void updateEG() {
	}

	public void getEG() {
	}
//目标基元
	public ArrayList<BeliefBean> getAllEG() {
		DaoServise ds = new DaoServise();
		ArrayList<BeliefBean> bs = ds.getEGs("luohang");
		return bs;
	}
//条件基元
	public ArrayList<BeliefBean> getAllEC() {
		DaoServise ds = new DaoServise();
		ArrayList<BeliefBean> bs = ds.getECs("luohang");
		
		return bs;
	}

	public void deleteEC() {

	}

	public void updateEC() {

	}

	public void getEC() {
	}

	public void saveEC(String userName, ArrayList<ElementNode> ecc) {
		if (ecc != null) {
			ArrayList<ElementBean> ebl = new ArrayList<ElementBean>();
			for (ElementNode eb : ecc) {
				ebl.add(eb.getInfo());
			}
			DaoServise ds = new DaoServise();
			if(ds.saveEC(ebl, userName))
				JOptionPane.showMessageDialog(null, "添加成功！", "写入条件基元提示", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	public void saveEG(String userName, ArrayList<ElementNode> ecc) {
		if (ecc != null) {
			ArrayList<ElementBean> ebl = new ArrayList<ElementBean>();
			for (ElementNode eb : ecc) {
				ebl.add(eb.getInfo());
			}
			DaoServise ds = new DaoServise();
			if(ds.saveEG(ebl, userName))
				JOptionPane.showMessageDialog(null, "添加成功！", "写入目标基元提示", JOptionPane.INFORMATION_MESSAGE);

		}
	}
}

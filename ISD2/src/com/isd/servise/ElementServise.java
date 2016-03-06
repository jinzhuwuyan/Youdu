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
//Ŀ���Ԫ
	public ArrayList<BeliefBean> getAllEG() {
		DaoServise ds = new DaoServise();
		ArrayList<BeliefBean> bs = ds.getEGs("luohang");
		return bs;
	}
//������Ԫ
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
				JOptionPane.showMessageDialog(null, "��ӳɹ���", "д��������Ԫ��ʾ", JOptionPane.INFORMATION_MESSAGE);
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
				JOptionPane.showMessageDialog(null, "��ӳɹ���", "д��Ŀ���Ԫ��ʾ", JOptionPane.INFORMATION_MESSAGE);

		}
	}
}

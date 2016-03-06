package com.isd.servise;

import java.util.ArrayList;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import com.isd.bean.BeliefBean;
import com.isd.bean.ElementBean;
import com.isd.constant.Constant;
import com.isd.dao.ElementDao;
import com.isd.dao.UserDao;

/**
 * ���û��Ի�Ԫ���в���ʱ�������ݿ���в������û��ı��ֻ���ڴ��е����ݣ����û��ֶ���������˳�����ʱ�����ڴ��еĻ�Ԫ��
 * Ϣ�������������ݿ⣬�û��ٴδ�Ӧ��ʱ�� �򽫱������ݿ�����ݳ�ʼ�������ڣ����û��鿴�����û���ӻ����޸Ļ�Ԫʱ��
 * ��̨�򽫴˻�Ԫ��Ϣ���������������߾������صķ������жϵ�ǰ��ӻ��޸ĵĻ�Ԫ�Ƿ����.
 * 
 * @author luohang
 * 
 */
public class DaoServise {

	UserDao ud = new UserDao();
	ElementDao ed = new ElementDao();

	/**
	 * �ֳֶ��豸�Ƿ������ʱ���浱ǰ����״̬��ʵʱ������ʾ��Ϣ�������жϣ����ػ��̨���ݿ⣩����ͼ�ķ�ʽ��ʾ�� *����ǰ�Ļ�Ԫ����������
	 * 
	 * @param elements
	 *            Ҫ����Ļ�Ԫ��������
	 * @param userName
	 *            Ҫ�����Ԫ���û���
	 * @return
	 */
	public boolean saveEC(ArrayList<ElementBean> elements, String userName) {
		try {
			ElementBean eb = new ElementBean();
			int hostId = ud.registUser(userName);
			ed.deleteElementOfUser(userName);
			for (int i = 0; i < elements.size(); i++) {
				eb = elements.get(i);
				ed.registElement(Constant.ELEMENT_CONDITION, eb);
				ed.createElementTable(ed.getElementTableName(
						Constant.ELEMENT_CONDITION, eb.getName(), hostId));
				ed.initElement(Constant.ELEMENT_CONDITION, eb);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param elements
	 *            Ҫ����Ļ�ԪĿ������
	 * @param userName
	 *            Ҫ�����Ԫ���û���
	 * @return
	 */
	public boolean saveEG(ArrayList<ElementBean> elements, String userName) {
		try {
			ElementBean eb = new ElementBean();
			int hostId = ud.registUser(userName);
			for (int i = 0; i < elements.size(); i++) {
				eb = elements.get(i);
				eb.setHostId(hostId);
				ed.registElement(Constant.ELEMENT_GOAL, eb);
				ed.createElementTable(ed.getElementTableName(
						Constant.ELEMENT_GOAL, eb.getName(), hostId));

				ed.initElement(Constant.ELEMENT_GOAL, eb);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * ���»�Ԫ
	 * 
	 * @param type
	 * @param eb
	 * @param hostName
	 * @return
	 */
	public boolean UpdateElement(String type, ElementBean eb, String hostName) {
		try {
			ud.registUser(hostName);
			if (type.equalsIgnoreCase("goal")) {
				ed.registElement(Constant.ELEMENT_GOAL, eb);
				ed.createElementTable(ed.getElementTableName(
						Constant.ELEMENT_GOAL, eb.getName(), eb.getHostId()));
				ed.initElement(Constant.ELEMENT_GOAL, eb);
			} else if (type.equalsIgnoreCase("condition")) {
				ed.registElement(Constant.ELEMENT_CONDITION, eb);
				ed.createElementTable(ed.getElementTableName(
						Constant.ELEMENT_CONDITION, eb.getName(),
						eb.getHostId()));
				ed.initElement(Constant.ELEMENT_CONDITION, eb);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * �����û����ֻ�ȡ�������
	 * 
	 * @param userName
	 * @return
	 */
	public ArrayList<BeliefBean> getBeliefs(String userName) {
		ArrayList<BeliefBean> bs = new ArrayList<BeliefBean>();
		try {
			ArrayList<ElementBean> cs = ed.getAllElement(
					Constant.ELEMENT_CONDITION, userName);
			ArrayList<ElementBean> gs = ed.getAllElement(Constant.ELEMENT_GOAL,
					userName);
			if (cs != null) {
				for (ElementBean e : cs) {
					BeliefBean b = new BeliefBean(e.getId(), e.getUuid(),
							e.getName(), e.getCandV(), e.getPrecursorName(),
							e.getPrecursorId(), e.getHostId());
					bs.add(b);
				}
			}
			if (gs != null) {
				for (ElementBean e : gs) {
					BeliefBean b = new BeliefBean(e.getId(), e.getUuid(),
							e.getName(), e.getCandV(), e.getPrecursorName(),
							e.getPrecursorId(), e.getHostId());
					bs.add(b);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bs;
	}

	/**
	 * �����������ֺ���������ȡ�ض������
	 * 
	 * @param name
	 * @return
	 */
	public BeliefBean getBeliefByUNAndEN(String name, String userName) {
		BeliefBean bb = new BeliefBean();
		int hostId = ud.getUserId(userName);
		ElementBean ebg = ed.getElement(Constant.ELEMENT_GOAL, name, hostId);
		ElementBean ebc = ed.getElement(Constant.ELEMENT_CONDITION, userName,
				hostId);
		if (ebg != null) {
			return bb = new BeliefBean(ebg.getId(), ebg.getUuid(),
					ebg.getName(), ebg.getCandV(), ebg.getPrecursorName(),
					ebg.getPrecursorId(), ebg.getHostId());
		} else if (ebc != null) {
			return bb = new BeliefBean(ebc.getId(), ebc.getUuid(),
					ebc.getName(), ebc.getCandV(), ebc.getPrecursorName(),
					ebc.getPrecursorId(), ebc.getHostId());
		}
		return null;
	}

	public ArrayList<BeliefBean> getEGs(String userName) {
		ArrayList<BeliefBean> bs = new ArrayList<BeliefBean>();
		try {
			ArrayList<ElementBean> gs = ed.getAllElement(Constant.ELEMENT_GOAL,
					userName);
			if (gs != null) {
				for (ElementBean e : gs) {
					BeliefBean b = new BeliefBean(e.getId(), e.getUuid(),
							e.getName(), e.getCandV(), e.getPrecursorName(),
							e.getPrecursorId(), e.getHostId());
					bs.add(b);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bs;
	}

	public ArrayList<BeliefBean> getECs(String userName) {
		ArrayList<BeliefBean> bs = new ArrayList<BeliefBean>();
		try {
			ArrayList<ElementBean> cs = ed.getAllElement(
					Constant.ELEMENT_CONDITION, userName);
			if (cs != null) {
				for (ElementBean e : cs) {
					BeliefBean b = new BeliefBean(e.getId(), e.getUuid(),
							e.getName(), e.getCandV(), e.getPrecursorName(),
							e.getPrecursorId(), e.getHostId());
					bs.add(b);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return bs;
	}

	public static void main(String[] args) {
		getBeliefTest();
		// DaoServise ds = new DaoServise();
		// ElementBean eb = new ElementBean();
		// HashMap<String, String[]> CandV = new HashMap<String, String[]>();
		// CandV.put("length", new String[] { "50", "����" });
		// eb.setName("cattt");
		// eb.setCandV(CandV);
		// ds.addElement("goal", eb, "hang");
	}

	public static void getBeliefTest() {
		DaoServise ds = new DaoServise();
		ArrayList<BeliefBean> bs = ds.getBeliefs("luohang");
		for (BeliefBean b : bs) {
			System.out.println(b.getName());
			for (Entry<String, String[]> e : b.getCandV().entrySet()) {
				System.out.println("" + e.getKey() + e.getValue()[0]
						+ e.getValue()[1]);
			}
			System.out.println("--------------");
		}
		// BeliefBean b = ds.getBeliefByUNAndEN("dog", "luohang");
		// for (Entry<String, String[]> e : b.getCandV().entrySet()) {
		// System.out.println("" + e.getKey() + e.getValue()[0]
		// + e.getValue()[1]);
		// }
		// System.out.println("--------------");
	}

}

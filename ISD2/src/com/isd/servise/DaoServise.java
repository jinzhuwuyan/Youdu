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
 * 当用户对基元进行操作时不对数据库进行操作，用户改变的只是内存中的数据，当用户手动保存或者退出程序时，则将内存中的基元信
 * 息保存至本地数据库，用户再次打开应用时， 则将本地数据库的数据初始化至窗口，供用户查看，在用户添加或者修改基元时，
 * 后台则将此基元信息发送至服务器或者经过本地的服务处理，判断当前添加或修改的基元是否合适.
 * 
 * @author luohang
 * 
 */
public class DaoServise {

	UserDao ud = new UserDao();
	ElementDao ed = new ElementDao();

	/**
	 * 手持端设备是否可以临时保存当前工作状态，实时弹出提示信息（进行判断，本地或后台数据库），以图的方式显示， *将当前的基元保存至本地
	 * 
	 * @param elements
	 *            要保存的基元条件序列
	 * @param userName
	 *            要保存基元的用户名
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
	 *            要保存的基元目标序列
	 * @param userName
	 *            要保存基元的用户名
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
	 * 更新基元
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
	 * 根据用户名字获取所有信念集
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
	 * 根据信念名字和主机名获取特定的信念集
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
		// CandV.put("length", new String[] { "50", "长度" });
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

package com.isd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JOptionPane;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.isd.bean.ElementBean;
import com.isd.constant.Constant;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class ElementDao {

	private UserDao hd;

	public ElementDao() {
		if (!TableExist("ECcontents")) {
			try {
				runner.update(Constant.CREATE_ECCONTENT);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (!TableExist("EGcontents")) {
			try {
				runner.update(Constant.CREATE_EGCONTENT);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		hd = new UserDao();
	}

	final QueryRunner runner = new QueryRunner(new ComboPooledDataSource());

	/**
	 * 创建表
	 * 
	 * @param tableName
	 * @return 成功：true；失败：false
	 */
	public boolean createElementTable(String elementTbaleName) {
		if (!elementTbaleName.contains("-1") && !TableExist(elementTbaleName)) {
			try {
				runner.update("create table "
						+ elementTbaleName
						+ " (id int not null primary key auto_increment,C varchar(30) not null,V varchar(50) ,type varchar(50));");
				JOptionPane.showMessageDialog(null, "添加成功！", "写入"+elementTbaleName+"表提示", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param tableName
	 * @return
	 */
	public String getElementTableName(String elementKind, String name,
			int hostId) {
		if (Constant.ELEMENT_CONDITION.equals(elementKind)) {
			return "EC_" + getElementId(elementKind, name, hostId);
		} else {
			return "EG_" + getElementId(elementKind, name, hostId);
		}

	}

	/**
	 * 
	 * @param ElementKind
	 * @param eb
	 * @return
	 */
	public int registElement(String ElementKind, ElementBean eb) {
		String name = eb.getName();
		int userId = eb.getHostId();
		String uuid = eb.getUuid();
		String precursor = eb.getPrecursorId();
		try {
			if (getElementId(ElementKind, name, userId) == -1) {
				runner.update("insert into " + ElementKind
						+ " (name,uuid,precursorId,hostId) values(?,?,?,?)",
						name, uuid, precursor, userId);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		return getElementId(ElementKind, name, userId);
	}

	/**
	 * 初始化基元
	 * 
	 * @param eb
	 * @return
	 */
	public boolean initElement(String ElementKind, ElementBean eb) {
		String elementTbaleName = getElementTableName(ElementKind,
				eb.getName(), eb.getHostId());
		if (TableExist(elementTbaleName)) {
			resetElement(elementTbaleName);
			try {
				for (Entry<String, String[]> en : eb.getCandV().entrySet()) {
					runner.update("insert into " + elementTbaleName
							+ " (C,V,type) values(?,?,?)", en.getKey(),
							en.getValue()[0], en.getValue()[1]);
				}
			} catch (SQLException e) {

				return false;
			}
		} else {
			return false;
		}
		return true;
	}

	/**
	 * 
	 * @param name
	 * @param hostId
	 * @return
	 */
	public ElementBean getElement(String ElementKind, String name, int hostId) {
		String conditionTableName = getElementTableName(ElementKind, name,
				hostId);
		ElementBean ibb = null;
		if (TableExist(conditionTableName)) {
			try {
				ibb = runner.query("select * from " + conditionTableName,
						new ResultSetHandler<ElementBean>() {
							@Override
							public ElementBean handle(ResultSet arg0)
									throws SQLException {
								HashMap<String, String[]> map = new HashMap<String, String[]>();
								ElementBean inbb = null;
								while (arg0.next()) {
									String key = arg0.getString(2);
									String[] value = new String[] {
											arg0.getString(3),
											arg0.getString(4) };
									map.put(key, value);
								}
								if (map.size() == 0)
									return null;
								else {
									inbb = new ElementBean();
									inbb.setCandV(map);
								}
								return inbb;
							}
						});
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ibb;
	}

	/**
	 * 
	 * @param ElementKind
	 * @param name
	 *            基元名name和hostId属性值不为空
	 * @param hostId
	 * @return
	 */
	public int getElementId(String ElementKind, String ElementName, int hostId) {
		int bid = -1;
		String sql = "select id from " + ElementKind
				+ " where name=(?) and hostId=(?)";
		if (TableExist(ElementKind)) {
			try {
				bid = runner.query(sql, new ResultSetHandler<Integer>() {
					@Override
					public Integer handle(ResultSet arg0) throws SQLException {
						if (arg0.next()) {
							return arg0.getInt(1);
						}
						return -1;
					}
				}, ElementName, hostId);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bid;
	}

	/**
	 * 
	 * @param ElementKind
	 *            Constant.ELEMENT_GOAL : 目标基元; Constant.ELEMENT_CONDITION ：条件基元
	 * @param userName
	 *            用户名
	 * @return
	 */
	public ArrayList<ElementBean> getAllElement(final String ElementKind,
			String userName) {
		int hostId = hd.getUserId(userName);
		ArrayList<ElementBean> bns = null;
		String sql = "select egc1.*,egc2.name precursorName from "
				+ ElementKind + " egc1 left JOIN " + ElementKind
				+ " egc2 ON egc1.precursorId=egc2.uuid and egc1.hostId=(?)";
		try {
			bns = runner.query(sql,
					new ResultSetHandler<ArrayList<ElementBean>>() {
						@Override
						public ArrayList<ElementBean> handle(ResultSet arg0)
								throws SQLException {
							ArrayList<ElementBean> bins = new ArrayList<ElementBean>();
							while (arg0.next()) {
								ElementBean ebTemp = new ElementBean();
								ebTemp.setId(arg0.getInt("id"));
								ebTemp.setName(arg0.getString("name"));
								ebTemp.setPrecursorId(arg0
										.getString("precursorId"));
								ebTemp.setUuid(arg0.getString("uuid"));
								if (null == arg0.getString("precursorName")) {
									ebTemp.setPrecursorName("null");
									ebTemp.setPrecursorId("-1");
								} else {
									ebTemp.setPrecursorName(arg0
											.getString("precursorName"));
									ebTemp.setPrecursorId(arg0
											.getString("precursorId"));
								}
								ebTemp.setHostId(arg0.getInt("hostId"));
								ElementBean ebTempc = getElement(ElementKind,
										ebTemp.getName(), ebTemp.getHostId());
								ebTemp.setCandV(ebTempc.getCandV());
								bins.add(ebTemp);
							}
							return bins;
						}
					}, hostId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bns;
	}

	/**
	 * 重置基元
	 * 
	 * @param ETN
	 *            基元表名
	 */
	public void resetElement(String ETN) {
		if (!ETN.contains("-1")) {
			try {
				runner.update("drop table " + ETN);
				createElementTable(ETN);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * 更新基元
	 * 
	 * @param eb
	 * @return
	 */
	public boolean updateElement(String ElementKind, ElementBean eb) {
		String elementTbaleName = getElementTableName(ElementKind,
				eb.getName(), eb.getHostId());
		resetElement(elementTbaleName);
		initElement(ElementKind, eb);
		return true;
	}

	/**
	 * 判断表是否存在
	 * 
	 * @param tableName
	 * @return
	 */
	public boolean TableExist(String tableName) {
		try {
			runner.query("select * from " + tableName,
					new ResultSetHandler<Boolean>() {
						@Override
						public Boolean handle(ResultSet arg0)
								throws SQLException {
							return true;
						}
					});
		} catch (SQLException e) {
			return false;
		}
		return true;
	}

	public void deleteElementOfUser(String userName) {
		// int id = hd.getUserId(UserName);
		// String

	}

}

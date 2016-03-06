package com.isd.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class UserDao {

	final static QueryRunner runner = new QueryRunner(
			new ComboPooledDataSource());

	public UserDao() {
		try {
			if (!isExist("User")) {
				runner.update("create table User(id int primary key auto_increment,name varchar(30) not null,UserId int not null default '0')");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public int getUserId(String UserName) {
		int UserId = -1;
		try {
			UserId = runner.query("select Id from User where name=(?)",
					new ResultSetHandler<Integer>() {
						@Override
						public Integer handle(ResultSet arg0)
								throws SQLException {
							if (arg0.next()) {
								return arg0.getInt(1);
							}
							return -1;
						}
					}, UserName);
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return UserId;
	}

	public int registUser(String UserName) {
		if (getUserId(UserName) == -1) {
			try {
				runner.update("insert into  User(name) values(?)", UserName);
			} catch (SQLException e) {
				e.printStackTrace();
				return -1;
			}
		}
		return getUserId(UserName);
	}

	public boolean deleteUser(String UserName) {
		try {
			runner.update("delete from User where name=(?) ", UserName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;

	}

	public static boolean isExist(String tableName) {
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
}

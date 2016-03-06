package com.isd.constant;

public class Constant {
	public static final int COMMOND_ADDEC = 0;
	public static final int COMMOND_ADDEG = 1;
	private static String hsql = "`id` int(11) NOT NULL auto_increment,"
			+ "`uuid` varchar(255) NOT NULL,"
			+ "`name` varchar(30) default NULL,"
			+ "`precursorId` varchar(255) default NULL,"
			+ "`hostId` int(11) NOT NULL,"
			+ " PRIMARY KEY  (`id`),"
			+ "KEY `hostId` (`hostId`),"
			+ "KEY `precursorId` (`precursorId`),"
			+ " CONSTRAINT `eccontents_ibfk_1` FOREIGN KEY (`hostId`) REFERENCES `user` (`id`)"
			+ ");";
	public static final String CREATE_ECCONTENT = "CREATE TABLE eccontents ("
			+ hsql;
	public static final String CREATE_EGCONTENT = "CREATE TABLE egcontents ("
			+ hsql;
	public static final String ELEMENT_GOAL = "EGCONTENTS";
	public static final String ELEMENT_CONDITION = "ECCONTENTS";
}

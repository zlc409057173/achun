package com.clear2pay.cn.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

public class DBUtil {
	private static Logger log = Logger.getLogger(DBUtil.class);
	private static String DRIVER = "";
	private static String URL = "";
	private static String USER = "";
	private static String PASSWORD = "";
	private static final String DB_CONFIG = "config/DB";
//	private static Connection conn = null;
	static ResourceBundle resource = null;
	static{
		resource = ResourceBundle.getBundle(DB_CONFIG);
		DRIVER = resource.getString("driver");
		URL = resource.getString("url");
		USER = resource.getString("user");
		PASSWORD = resource.getString("password");
	}
	public final Connection openConnection(){
		Connection	conn = null;
		try {
//			if(conn==null){
				Class.forName(DRIVER);
				conn = DriverManager.getConnection(URL, USER, PASSWORD);
//			}
		} catch (ClassNotFoundException e) {
			log.error("类找不到！");
		}catch (SQLException e){
			log.error("连接数据库失败！");
		}
		return conn;
	}
	
	public final boolean closeConnection(Connection conn,PreparedStatement ps, ResultSet rs){
		try {
			if(conn != null){
				conn.close();
			}
			if(ps != null){
				ps.close();
			}
			if(rs != null){
				rs.close();
			}
		} catch (SQLException e) {
			log.error("连接关闭失败！");
		}
		return true;
	}
	
}

package com.clear2pay.cn.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clear2pay.cn.dao.EmulatorTimerDao;
import com.clear2pay.cn.entity.EmulatorTimer;
import com.clear2pay.cn.util.DBUtil;

public class EmulatorTimerDaoImpl implements EmulatorTimerDao {
	
	public int[] insertEmulatorTimer(List<EmulatorTimer> et) throws SQLException{
		DBUtil dbutil = new DBUtil();
		Connection conn = dbutil.openConnection();
		PreparedStatement ps = null;
		String sql = "insert into EMULATORTIMER (EMULATORTIMERKEY,FOLDERPATH,BAKFOLDERPATH,ERRORFOLDERPATH,QUEUENAME,description,WHENMODIFY,ENABLEFLAG) " +
				"values (?,?,?,?,?,?,?,?)";
		ps = conn.prepareStatement(sql);
		for (EmulatorTimer emulatorTimer : et) {
			ps.setInt(1, 1);
			ps.setString(2, emulatorTimer.getFolderPath());
			ps.setString(3, emulatorTimer.getBakfolderPath());
			ps.setString(4, emulatorTimer.getErrorfolderPath());
			ps.setString(5, emulatorTimer.getQueueName());
			ps.setString(6, emulatorTimer.getDescription());
			ps.setDate(7, new Date(System.currentTimeMillis()));
			ps.setString(8, "T");
			ps.addBatch();
		}
		int[] count = ps.executeBatch();
		dbutil.closeConnection(conn, ps, null);
		return count;
	}
	
	public List<EmulatorTimer> getEmulatorTimerList(int pageNo, int pageSize) throws SQLException{
		List<EmulatorTimer> list = new ArrayList<EmulatorTimer>();
		DBUtil dbutil = new DBUtil();
		Connection conn = dbutil.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		EmulatorTimer et = null;
		String sql = "SELECT * FROM (SELECT temp.*, ROWNUM RN FROM (SELECT * FROM EmulatorTimer where ENABLEFLAG = 'T') temp WHERE ROWNUM <= ?) WHERE RN >= ?";
		ps = conn.prepareStatement(sql);
		ps.setInt(1, pageNo*pageSize);
		ps.setInt(2, (pageNo-1)*pageSize+1);
		rs = ps.executeQuery();
		while(rs.next()){
			et = new EmulatorTimer();
			et.setEmulatortimerKey(rs.getInt("EMULATORTIMERKEY"));
			et.setFolderPath(rs.getString("FOLDERPATH"));
			et.setBakfolderPath(rs.getString("BAKFOLDERPATH"));
			et.setErrorfolderPath(rs.getString("ERRORFOLDERPATH"));
			et.setQueueName(rs.getString("QUEUENAME"));
			et.setDescription(rs.getString("description"));
			et.setWhenmodify(rs.getDate("WHENMODIFY"));
			et.setEnableFlag(rs.getString("ENABLEFLAG"));
			list.add(et);
		}
		dbutil.closeConnection(conn, ps, rs);
		return list;
	}
	
	public int selectMaxPageNo(int pageSize) throws SQLException{
		DBUtil dbutil = new DBUtil();
		Connection conn = dbutil.openConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select count(*) from EmulatorTimer where ENABLEFLAG = 'T'";
		ps = conn.prepareStatement(sql);
		rs = ps.executeQuery();
		int count = 0;
		while(rs.next()){
			count = rs.getInt(1);
		}
		dbutil.closeConnection(conn, ps, rs);
		return (count-1)/pageSize+1;
	}
}

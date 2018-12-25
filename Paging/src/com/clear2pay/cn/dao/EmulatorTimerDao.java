package com.clear2pay.cn.dao;

import java.sql.SQLException;
import java.util.List;

import com.clear2pay.cn.entity.EmulatorTimer;

public interface EmulatorTimerDao {
	public int[] insertEmulatorTimer(List<EmulatorTimer> et) throws SQLException;
	public List<EmulatorTimer> findEmulatorTimer(int pageNo,int pageSize) throws SQLException;
	public int selectMaxPageNo(int pageSize) throws SQLException;
}

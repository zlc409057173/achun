package com.clear2pay.cn.service;

import java.sql.SQLException;
import java.util.List;

import com.clear2pay.cn.entity.EmulatorTimer;

public interface EmulatorTimerService {
	int findMaxPageNo(int pasgeSize) throws SQLException;
	
	List<EmulatorTimer> findEmulatorTimer(int pageNo, int pageSize) throws SQLException;
}

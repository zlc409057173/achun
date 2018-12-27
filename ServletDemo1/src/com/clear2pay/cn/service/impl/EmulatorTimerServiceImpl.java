package com.clear2pay.cn.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.clear2pay.cn.dao.EmulatorTimerDao;
import com.clear2pay.cn.dao.impl.EmulatorTimerDaoImpl;
import com.clear2pay.cn.entity.EmulatorTimer;
import com.clear2pay.cn.service.EmulatorTimerService;

public class EmulatorTimerServiceImpl implements EmulatorTimerService {

	public int findMaxPageNo(int pageSize) throws SQLException {
    	EmulatorTimerDao etDao = new  EmulatorTimerDaoImpl();
    	int maxNo = etDao.selectMaxPageNo(pageSize);
		return maxNo;
	}

	public List<EmulatorTimer> findEmulatorTimer(int pageNo,
			int pageSize) throws SQLException {
		EmulatorTimerDao etDao = new  EmulatorTimerDaoImpl();
		List<EmulatorTimer> list = etDao.getEmulatorTimerList(pageNo, pageSize);
		return list;
	}
	

}

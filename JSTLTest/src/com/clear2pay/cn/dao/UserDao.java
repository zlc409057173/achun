package com.clear2pay.cn.dao;

import java.util.ArrayList;
import java.util.List;

import com.clear2pay.cn.entity.User;

public class UserDao {
	public List<User> getAllUsers(){
		List<User> list = new ArrayList<User>();
		User u1 = new User();
		u1.setAge(1);
		u1.setName("张三");
		list.add(u1);
		User u2 = new User();
		u2.setAge(2);
		u2.setName("李四");
		list.add(u2);
		User u3 = new User();
		u3.setAge(3);
		u3.setName("王五");
		list.add(u3);
		User u4 = new User();
		u4.setAge(4);
		u4.setName("赵六");
		list.add(u4);
		return list;
	}
}

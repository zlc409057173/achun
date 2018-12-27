package com.clear2pay.cn.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.clear2pay.cn.entity.EmulatorTimer;
import com.clear2pay.cn.service.EmulatorTimerService;
import com.clear2pay.cn.service.impl.EmulatorTimerServiceImpl;

public class ProcessServlet extends HttpServlet{
	private static Logger log = Logger.getLogger(ProcessServlet.class);
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
	}
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response){
		// TODO Auto-generated method stub
		EmulatorTimerService etService = new EmulatorTimerServiceImpl();
    	String pageNoStr = (String)request.getParameter("pageNo");
    	String pageSizeStr = (String)request.getParameter("pageSize");
    	if(pageSizeStr == null){
    		pageSizeStr = "10";
    	}
		int pageSize = Integer.parseInt(pageSizeStr);
		if(pageNoStr ==null || pageNoStr.equals("0")){
    		pageNoStr = "1";
    	}
    	int	pageNo = Integer.parseInt(pageNoStr);
    	int maxNo = 0;
    	List<EmulatorTimer> list = null;
		try {
			maxNo = etService.findMaxPageNo(pageSize);
			if(pageNo >=maxNo ){
				pageNo = maxNo;
			}
			list = etService.findEmulatorTimer(pageNo,pageSize);
		} catch (SQLException e) {
			log.error("数据查询异常！");
		}
    	request.setAttribute("etList", list);
    	request.setAttribute("pageNo", pageNo);
    	request.setAttribute("pageSize", pageSize);
    	request.setAttribute("maxNo", maxNo);
    	try {
			request.getRequestDispatcher("show.jsp").forward(request, response);
		} catch (ServletException e) {
			log.error("Servlet Exception"+e);
		} catch (IOException e) {
			log.error("IO Exception"+e);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(request, response);
	}
	
	@Override
	public void destroy() {
		super.destroy();
	}
}

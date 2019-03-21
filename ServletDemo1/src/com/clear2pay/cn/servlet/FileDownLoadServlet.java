package com.clear2pay.cn.servlet;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

public class FileDownLoadServlet extends HttpServlet{
	private static Logger log =Logger.getLogger(FileDownLoadServlet.class);
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String filePath = request.getParameter("filePath");
		response.addHeader("Content-Type", "attachment;fileName="+System.currentTimeMillis()+".txt");
		File file = new File(filePath);
		//二进制文件下载
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
		ServletOutputStream sos = response.getOutputStream();
		byte[] b = new byte[1024];
		int len = -1;
		while((len = bis.read(b)) != -1){
			sos.write(b, 0, len);
			sos.flush();
		}
		sos.close();
		bis.close();
		//文本文件下载
		BufferedReader br = new BufferedReader(new FileReader(file));
		PrintWriter pw = response.getWriter();
		char[] c = new char[1024];
		while((len = br.read(c)) != -1){
			pw.write(c, 0, len);
			pw.flush();
		}
		pw.close();
		pw.close();
	}	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}

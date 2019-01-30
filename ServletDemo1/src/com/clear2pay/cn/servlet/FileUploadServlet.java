package com.clear2pay.cn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.jspsmart.upload.File;
import com.jspsmart.upload.Files;
import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;

public class FileUploadServlet extends HttpServlet{
	private static Logger log =Logger.getLogger(FileUploadServlet.class);
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SmartUpload su = new SmartUpload();
		su.initialize(this.getServletConfig(), request, response);
		try {
			su.upload();
			Files files = su.getFiles();
			File file = null;
			for (int i = 0; i < files.getCount(); i++) {
				file = files.getFile(i);
				file.saveAs("upload/"+file.getFileName());
			}
			String routPath = request.getHeader("referer");
			response.sendRedirect(routPath);
		} catch (SmartUploadException e) {
			log.error("file upload fail !" + e);
		}
	}	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(req, resp);
	}
}

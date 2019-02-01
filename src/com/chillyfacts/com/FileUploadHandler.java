package com.chillyfacts.com;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

//@WebServlet("/upload")
public class FileUploadHandler extends HttpServlet {
	private static final long serialVersionUID = 8587244007560455832L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String file_name = null;
		System.out.println("Entering my session ");
		String test = "TEest";
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean isMultipartContent = ServletFileUpload
				.isMultipartContent(request);
		if (!isMultipartContent) {
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fields = upload.parseRequest(request);
			Iterator<FileItem> it = fields.iterator();
			if (!it.hasNext()) {
				return;
			}
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if (isFormField) {
					if (file_name == null) {
						if (fileItem.getFieldName().equals("file_name")) {
							file_name = fileItem.getString();
						}
					}
					System.out.println("file_name : " + null);
				} else {
					if (fileItem.getSize() > 0) {
						//TODO: 
						File file = new File("E:\\uploaded_files\\"+ "AAMORALES" +"\\"
						+ test);
						createDirectory(file.getAbsolutePath());
				        String dirName = "AAMORALES";
				        fileItem.write(new File("E:\\uploaded_files\\" +dirName+"\\" +test+"\\"
								+ fileItem.getName()));
					}
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Test");
	}
	private void createDirectory(String path){
		File dir = new File(path);
		if (!dir.exists()) {
			Boolean isTrue = dir.mkdirs();
		}
	}
}

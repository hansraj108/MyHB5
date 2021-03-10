package com.hr.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.nio.charset.Charset;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FileDownloadController {
	
	private static final String INTERNAL_FILE="irregular-verbs-list.pdf";
	private static final String EXTERNAL_FILE_PATH="C:/Users/DELL/Downloads/Spring4MVCFileDownloadExample.zip";

	@RequestMapping(value={"/","/welcome"}, method = RequestMethod.GET)
    public String getHomePage(ModelMap model) {
        return "welcome";
    }
	
	@RequestMapping(value="/download/{type}", method= RequestMethod.GET)
	public void downloadFile(HttpServletResponse response, @PathVariable("type") String type) throws IOException{
		
		File file = null;
		
		if(type.equalsIgnoreCase("internal")) {
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			file = new File(classLoader.getResource(INTERNAL_FILE).getFile());
		}else {
			file = new File(EXTERNAL_FILE_PATH);
		}
		
		if(!file.exists()) {
			String errorMessage = "Sorry. The file you are looking for does not exist";
			System.out.println(errorMessage);
			OutputStream outputStream = response.getOutputStream();
			outputStream.write(errorMessage.getBytes(Charset.forName("UTF-8")));
			outputStream.close();
			return;
		}
		
		String mimeType = URLConnection.guessContentTypeFromName(file.getName());
		if(mimeType==null){
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		
		System.out.println("mimetype : "+mimeType);
		
		response.setContentType(mimeType);
		response.setHeader("Content-Disposition", String.format("attachment; filename=\"" +file.getName() +"\""));
		
		response.setContentLength((int) file.length());
		
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		 //Copy bytes from source to destination(outputstream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
	}
}

package com.nt;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.multipart.MultipartFile;


public class FileData {
	
	private List<MultipartFile> files;

	public List<MultipartFile> getFiles() {
		return files;
	}

	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	@Override
	public String toString() {
		return "FileData [files=" + files + "]";
	}
	
	

}

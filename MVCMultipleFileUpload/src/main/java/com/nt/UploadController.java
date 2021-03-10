package com.nt;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	
	@RequestMapping(value="/", method= RequestMethod.GET)
	public String showUploadForm(Model model) {
		return "uploadForm";
	}
	@RequestMapping(value="/save", method= RequestMethod.POST)
	public String saveFiles(@ModelAttribute("uploadFiles") FileData fileData, Model model) throws Exception {
		
		List<MultipartFile> files = fileData.getFiles();
		if (files != null && !files.get(0).getOriginalFilename().isEmpty())
		 {
            //Get the individual MultipartFile
            for (MultipartFile multipartFile : files)
            {
                //Write each MultipartFile in the directory specified
                if (!multipartFile.getOriginalFilename().isEmpty())
                {
                    BufferedOutputStream outputStream = new BufferedOutputStream(
                            new FileOutputStream(new File("E:\\JIP\\", multipartFile.getOriginalFilename())));

                    outputStream.write(multipartFile.getBytes());
                    outputStream.flush();
                    outputStream.close();
                }
            }
            model.addAttribute("message", "All Files are uploaded successfully!!");
        } 
        else
        {
            model.addAttribute("message", "Please select atleast one file!!");
        }

        return "uploadForm";
    }
}

		
package com.min.edu.util;

import java.io.File;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@Controller
@RequestMapping("/upload/")
public class UploadBean {
	
	@RequestMapping("/writeupload.do")
	public String writef() {
		return "write";
	}

	@RequestMapping(value="/uploadPro.do", method=RequestMethod.POST) 
	public String uploadPro(String writer, MultipartHttpServletRequest request) {

		try {
			MultipartFile mf = request.getFile("f_name");
			File copyFile = new File("c://save//"+mf.getOriginalFilename());	

			mf.transferTo(copyFile);
		}catch(Exception ex) {	ex.printStackTrace();	}
		return "init";
	}

}
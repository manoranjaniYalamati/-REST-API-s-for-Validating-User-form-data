package com.sri.prac.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sri.prac.Service.CenterService;
import com.sri.prac.model.Center;

@RestController
public class CenterController {
		@Autowired
		CenterService centerService;
		@PostMapping(value="center",consumes= {MediaType.APPLICATION_JSON_VALUE})
		@ResponseBody
		//method to pass the Post request from Controller to service
		public Center uploadCenter(@Valid @RequestBody Center center){										
			return centerService.upload(center);
		}
		
		@GetMapping(value="center",produces= {MediaType.APPLICATION_JSON_VALUE})
		//method to pass the Get request from Controller to service
		public List<Center> getAllCenter(){
			return centerService.getAll();
		}
	
}

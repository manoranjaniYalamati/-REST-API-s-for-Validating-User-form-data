package com.sri.prac.Service;

import java.time.Instant;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.sri.prac.Repository.CenterRepository;
import com.sri.prac.model.Center;
@Service
public class CenterService {
	@Autowired
	CenterRepository centerRepository;
	//method to save the training data to database
	public Center upload(Center center){
		Instant instant = Instant.now();									//generate epoch time and save it to object 
		long createdOn = instant.getEpochSecond();
		center.setCreatedOn(createdOn);
		System.out.println(center.getCenterName());
		centerRepository.save(center);										//save the object to repository/database
		return center;
	}
	
	//method to get all training centers data in database
	public List<Center> getAll(){
		return centerRepository.findAll();									
	}
	
}

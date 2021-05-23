package com.sri.prac.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sri.prac.model.Center;



@Repository
public interface CenterRepository extends JpaRepository<Center, String> {
	public List<Center>findAll();
}

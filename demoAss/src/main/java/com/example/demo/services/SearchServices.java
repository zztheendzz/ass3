package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Clinics;
import com.example.demo.model.Doctor;
import com.example.demo.model.Specializations;
import com.example.demo.modeldto.SearchDTO;

@Service
public class SearchServices {
	@Autowired
	ClinicsService clinicsService;
	
	@Autowired
	SpecializationsService specializationsService;
	
	@Autowired
	DoctorService doctorService;
	
	public SearchDTO search(SearchDTO searchDTO) {
		List<Doctor> doctors = new ArrayList();
		List<Clinics>  clinics= clinicsService.findByAddressLike(searchDTO.getKeySearch());
		List<Specializations>  specializations = specializationsService.findByNameLike(searchDTO.getKeySearch());
		if(searchDTO.getPrice() != 0) { doctors = doctorService.finByPrice(0);}
		
		searchDTO.setLisClinics(clinics);
		searchDTO.setLisDoctors(doctors);
		searchDTO.setLisSpecializations(specializations);
		return searchDTO;
	}


}

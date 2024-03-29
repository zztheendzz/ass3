package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patients;
import com.example.demo.model.Schedules;
import com.example.demo.modeldto.SchedulesDTO;
import com.example.demo.repository.SchedulesRepository;

@Service
public class SchedulesService {
	@Autowired
	SchedulesRepository schedulesRepository;
//	
	@Autowired
	DoctorService doctorService;

	public List<Schedules> listByDoctorId(int doctorId) {
		
		Doctor doctor = doctorService.findById(doctorId);
		 List<Schedules>  list= doctor.getSchedules();
		return list;	
	}
//	xac nhan lich kham voi benh nhan
	public Schedules setStatusAndDesById( int status,String description, int schedulesId) {
		Schedules schedules = schedulesRepository.findById(schedulesId).get();
		schedules.setDescription(description);
		schedules.setStatus(status);
		schedulesRepository.saveAndFlush(schedules);
		return schedules;
	}
	
	public SchedulesDTO setStatusAndDesByIdDTO( int status,String description, int schedulesId) {
		Schedules schedules = schedulesRepository.findById(schedulesId).get();
		schedules.setDescription(description);
		schedules.setStatus(status);
		schedulesRepository.saveAndFlush(schedules);
		SchedulesDTO schedulesDTO = new SchedulesDTO(schedules);
		return schedulesDTO;
	}
	
	public SchedulesDTO setStatusAndDesByIdDTO( SchedulesDTO schedulesDTO) {
		
		Schedules schedules = schedulesRepository.findById(schedulesDTO.getId()).get();
		schedules.setDescription(schedulesDTO.getDescription());
		schedules.setStatus(schedulesDTO.getStatus());
		schedulesRepository.saveAndFlush(schedules);
		SchedulesDTO schedulesDTO1 = new SchedulesDTO(schedules);
		return schedulesDTO1;
	}

	public void save(Schedules schedules) {
		schedulesRepository.save(schedules);
	}

	public List<Patients> findByDoctorId(int doctorId) {
		List<Schedules> list = schedulesRepository.findByDoctorId(doctorId).get();
		List<Patients>list2= new ArrayList<>();
		for (Schedules schedules : list) {
			list2.add(schedules.getPatients());
		}
		return list2;
	}
	
	public List<Schedules> findSchedulesByDoctorId(int doctorId) {
		List<Schedules> list = schedulesRepository.findByDoctorId(doctorId).get();
		return list;
	}
	
	public List<SchedulesDTO> findSchedulesByPatientsIdDTO(int patientsId) {
		List<Schedules> list = schedulesRepository.findByPatientsId(patientsId).get();
		List<SchedulesDTO> listDTO = new ArrayList<>();
		if(list==null) {
			return null;
		}
		for (Schedules schedules : list) {
			SchedulesDTO schedulesDTO = new SchedulesDTO(schedules);
			listDTO.add(schedulesDTO);
		}
		return listDTO;
	}
	
	
}

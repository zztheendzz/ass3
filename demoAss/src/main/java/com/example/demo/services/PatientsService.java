package com.example.demo.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Doctor;
import com.example.demo.model.Patients;
import com.example.demo.model.Schedules;
import com.example.demo.model.User;
import com.example.demo.modeldto.SchedulesDTO;
import com.example.demo.repository.DoctorRepository;
import com.example.demo.repository.PatientsRepository;
import com.example.demo.repository.SchedulesRepository;

@Service
public class PatientsService {
	@Autowired
	PatientsRepository patientsRepository;

	@Autowired
	DoctorRepository doctorRepository;

	@Autowired
	SchedulesService schedulesService;

	@Autowired
	DoctorService doctorService;

	@Autowired
	SchedulesRepository schedulesRepository;

	public Patients getPatientsById(int id) {
		try {
			Patients patients = patientsRepository.findById(id).get();
			System.out.println(patients.toString());
			return patients;
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}

	}

	public List<Schedules> getListScheByPatientsId(int patientsId) {

		List<Schedules> list = getPatientsById(patientsId).getSchedules();
		return list;
	}
	public Schedules createSchedule(SchedulesDTO schedulesDTO) {
		Schedules schedules = new Schedules(schedulesDTO);
		schedules.setDoctor(doctorService.findById(schedulesDTO.getDoctorId()));
		schedules.setPatients(getPatientsById(schedulesDTO.getPatientsId()));
		return schedulesRepository.saveAndFlush(schedules);
		
	}

}

package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clinic")
@Data
@NoArgsConstructor
public class Clinics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int id;
    
    @Column(name = "name")
	private String name;
    
    @Column(name = "address")
	private String address;
    
    @Column(name = "phone")
	private String phone;
    
    @Column(name = "introductionHTML")
	private String introductionHTML;
    
    @Column(name = "introductionMarkdown")
	private String introductionMarkdown;
    
    @Column(name = "description")
	private String description;
    
    @Column(name = "image")
	private String image;
    

	@OneToMany( fetch = FetchType.EAGER, mappedBy = "clinics")
	private List<Doctor>doctorUsers = new ArrayList<>();
	
    
	public List<Doctor> getDoctorUsers() {
		return doctorUsers;
	}
	public void setDoctorUsers(List<Doctor> doctorUsers) {
		this.doctorUsers = doctorUsers;
	}
	public int getId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

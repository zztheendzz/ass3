package com.example.demo.modeldto;

import java.util.List;

import com.example.demo.model.Clinics;
import com.example.demo.model.Doctor;
import com.example.demo.model.Specializations;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Setter
@Getter
public class SearchDTO {

	private String keySearch;
	private long price;
	private List<Clinics>lisClinics;
	private List<Doctor>lisDoctors;
	private List<Specializations>lisSpecializations;
	
	
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public List<Specializations> getLisSpecializations() {
		return lisSpecializations;
	}
	public void setLisSpecializations(List<Specializations> lisSpecializations) {
		this.lisSpecializations = lisSpecializations;
	}
	public List<Doctor> getLisDoctors() {
		return lisDoctors;
	}
	public void setLisDoctors(List<Doctor> lisDoctors) {
		this.lisDoctors = lisDoctors;
	}

	public String getKeySearch() {
		return keySearch;
	}
	public void setKeySearch(String keySearch) {
		this.keySearch = keySearch;
	}
	public List<Clinics> getLisClinics() {
		return lisClinics;
	}
	public void setLisClinics(List<Clinics> lisClinics) {
		this.lisClinics = lisClinics;
	}
	
}

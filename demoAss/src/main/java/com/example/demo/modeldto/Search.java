package com.example.demo.modeldto;

import java.util.List;

import com.example.demo.model.Clinics;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Search {
	private int typeSearch;
	private String keySearch;
	private List<Clinics>lisClinics;

}

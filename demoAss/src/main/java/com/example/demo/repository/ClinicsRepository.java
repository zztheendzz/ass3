package com.example.demo.repository;

import java.util.List;
import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Clinics;


@Repository
	public interface ClinicsRepository  extends JpaRepository<Clinics, Integer> {

	@Query("SELECT u FROM Clinics u WHERE u.id = :id")
	Optional<Clinics> findById(@Param("id") int id);
	

//	@Query("SELECT u FROM Clinics u WHERE u.address LIKE '%:address%'")
//	@Query("SELECT u FROM Clinics u WHERE u.address LIKE CONCAT('%',:address,'%')")
//	@Query("SELECT u FROM Clinics u WHERE u.address LIKE '%' || :lastname || '%'  ")
//	@Query("SELECT u FROM Clinics u WHERE u.address LIKE %:address%")
	@Query("SELECT u FROM Clinics u WHERE u.address LIKE %:address%")
	List<Clinics> findByAddressLike(String address);
	
	@Query("SELECT u FROM Clinics u WHERE u.name LIKE %:address%")
	Optional<List<Clinics>> findByNameLike(String address);
	
	@Query("SELECT u FROM Clinics u WHERE u.address LIKE %:address% OR u.name LIKE %:address%")
	List<Clinics> findByAddressOrNameLike(String address);
}

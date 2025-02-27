package com.example.demo.repository;

import java.util.Optional;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Patients;

@Repository
public interface PatientsRepository  extends JpaRepository<Patients, Integer> {

	@Query("SELECT u FROM Patients u WHERE u.id = :id")
	Optional<Patients> findById(@Param("id") int id);
//	Optional<User> findByEmail( String email);
}
package com.example.InspectionsDemo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectionRepo extends JpaRepository<Inspection, Long>, JpaSpecificationExecutor<Inspection> {

}

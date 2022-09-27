package com.example.InspectionsDemo;

import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@NoArgsConstructor
public class InspectionService implements InterfacService{

    @Autowired
    InspectionRepo inspectionRepo;
    @Override
    public List<InspectionDto> getInspections(){
        List<Inspection> inspections = inspectionRepo.findAll();
        return Mapper.toDtos(inspections);
    }

}

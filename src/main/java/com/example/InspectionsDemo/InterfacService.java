package com.example.InspectionsDemo;

import org.springframework.stereotype.Service;

import java.util.List;
public interface InterfacService {
     List<InspectionDto> getInspections();
}

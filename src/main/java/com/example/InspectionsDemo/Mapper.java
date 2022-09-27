package com.example.InspectionsDemo;

import java.util.ArrayList;
import java.util.List;

public class Mapper {
    public static InspectionDto toDto(Inspection inspection){
        InspectionDto inspectionDto = new InspectionDto();
        inspectionDto.setInspectionNo(inspection.getInspectionNo());
        inspectionDto.setInspectionAppDate(inspection.getInspectionAppDate());
        inspectionDto.setRequestDate(inspection.getRequestDate());
        inspectionDto.setScheduledInspectionDate(inspection.getScheduledInspectionDate());
        inspectionDto.setInspectionDate(inspection.getInspectionDate());
        inspectionDto.setMemberDealerName(inspection.getMemberDealerName());
        inspectionDto.setMake(inspection.getMake());
        inspectionDto.setSeries(inspection.getSeries());
        inspectionDto.setChassis(inspection.getChassis());
        inspectionDto.setInvoiceNo(inspection.getInvoiceNo());
        inspectionDto.setBilledAmount(inspection.getBilledAmount());
        inspectionDto.setSurveyvor(inspection.getSurveyvor());
        inspectionDto.setStatus(inspection.getStatus());

        return inspectionDto;

    }
    public static List<InspectionDto> toDtos(List<Inspection> inspections) {
        List<InspectionDto> inspectionDtos = new ArrayList<>();
        for(Inspection inspection : inspections){
            inspectionDtos.add(toDto(inspection));
        }
        return inspectionDtos;
    }

}

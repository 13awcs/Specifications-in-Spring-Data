package com.example.InspectionsDemo;

import lombok.Data;

import java.time.LocalDate;

@Data
public class InspectionDto {
    private String inspectionNo;
    private LocalDate inspectionAppDate;
    private LocalDate requestDate;
    private LocalDate scheduledInspectionDate;
    private LocalDate inspectionDate;
    private String memberDealerName;
    private String make;
    private String series;
    private String chassis;
    private String invoiceNo;
    private Integer billedAmount;
    private String surveyvor;
    private String status;
}

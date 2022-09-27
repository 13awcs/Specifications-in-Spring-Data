package com.example.InspectionsDemo;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Inspection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inspectionNo;
    private LocalDate inspectionAppDate;
    private String invoiceNo;
    private LocalDate invoiceIssueDate;
    private LocalDate bankTransferDate;
    private LocalDate requestDate;
    private LocalDate scheduledInspectionDate;
    private LocalDate inspectionDate;
    private String status;
    private String make;
    private String series;
    private String chassis;
    private String memberDealerNo;
    private String memberDealerName;
    private String branch;
    private Integer billedAmount;
    private String surveyvor;

}

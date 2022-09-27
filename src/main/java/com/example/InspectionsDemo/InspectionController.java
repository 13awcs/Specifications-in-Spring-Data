package com.example.InspectionsDemo;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class InspectionController {

    @Autowired
    InterfacService inspectionService;
    @Autowired
    InspectionRepo inspectionRepo;
    @GetMapping("inspections")
    public Object getInspections(){
        return inspectionService.getInspections();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/inspection")
    @ResponseBody
    public List<Inspection> search(@RequestParam(value = "search") String search) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        LocalDate localDate = LocalDate.parse(search,formatter);
        System.out.println("hahaha "+search);
        InspectionSpecificationsBuilder builder = new InspectionSpecificationsBuilder();
        //Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?|),");
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)([a-zA-Z0-9\\-]*)");
        Matcher matcher = pattern.matcher(search + ",");

        System.out.println("hello "+matcher);
        while (matcher.find()) {
            System.out.println("aaa");
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<Inspection> spec = builder.build();
        System.out.println("search:"+spec);
        return inspectionRepo.findAll(spec);
    }

//    @GetMapping("inspections/search")
//    public Object searchInspections(@RequestParam(required = false) Input field,@RequestParam(required = false) String value){
////        System.out.println("haha"+field+"ada"+value+"hihi"+keyword);
//        return inspectionService.searchInspection(field);
//    }

}

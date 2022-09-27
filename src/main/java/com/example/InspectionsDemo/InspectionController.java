package com.example.InspectionsDemo;

import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

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
        InspectionSpecificationsBuilder builder = new InspectionSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)([a-zA-Z0-9\\-]*)");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
        Specification<Inspection> spec = builder.build();
        return inspectionRepo.findAll(spec);
    }

}

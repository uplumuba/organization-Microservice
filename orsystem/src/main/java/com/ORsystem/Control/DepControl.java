package com.ORsystem.Control;

import com.ORsystem.ORgdto.Depdto;
import com.ORsystem.Service.Depservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/departments")
public class DepControl {

    @Autowired
    private Depservice depservice;
    @GetMapping
    public List<Depdto> getAllDepartments() {
        return depservice.getAllDepartments();
    }
    @GetMapping("/{id}")
    public Depdto getDepartmentById(@PathVariable Long id) {
        return depservice.getDepartmentById(id);
    }

    @PostMapping
    public Depdto addDepartment(@RequestBody Depdto departmentDTO) {
        return depservice.addDepartment(departmentDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        depservice.deleteDepartment(id);
    }
}
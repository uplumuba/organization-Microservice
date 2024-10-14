package com.ORsystem.Service;



import com.ORsystem.Model.Depclass;
import com.ORsystem.ORgdto.Depdto;
import com.ORsystem.Repository.DepRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Depservice {
    @Autowired
    private DepRepository departmentRepository;
    public List<Depdto> getAllDepartments() {
        return departmentRepository.findAll().stream()
                .map(dept -> new Depdto(dept.getId(), dept.getName(), dept.getLocation(), dept.getAbbreviatedName()))
                .collect(Collectors.toList());
    }
    public Depdto getDepartmentById(Long id) {
        Depclass dept = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
        return new Depdto(dept.getId(), dept.getName(), dept.getLocation(), dept.getAbbreviatedName());
    }
    public Depdto updateDepartment(Depdto dep) {
        Depclass dept = departmentRepository.findById(dep.getId()).get();
        if(dep.getAbbreviatedName() != null) {
            dept.setAbbreviatedName(dep.getAbbreviatedName());
        }
        if (dep.getLocation()!= null) {
           dept.setLocation(dep.getLocation());
        }
        if (dep.getName()!= null) {
            dept.setName(dep.getName());
        }
        Depclass updateddata=departmentRepository.save(dept);
        return new Depdto(
                updateddata.getId(),
                updateddata.getName(),
                updateddata.getAbbreviatedName(),
                updateddata.getLocation()
        );




    }

    public Depdto addDepartment(Depdto departmentDTO) {
        Depclass dept = new Depclass();
        dept.setName(departmentDTO.getName());
        dept.setLocation(departmentDTO.getLocation());
        dept.setAbbreviatedName(departmentDTO.getAbbreviatedName());
        Depclass savedDept = departmentRepository.save(dept);
        return new Depdto(savedDept.getId(), savedDept.getName(), savedDept.getLocation(), savedDept.getAbbreviatedName());
    }
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
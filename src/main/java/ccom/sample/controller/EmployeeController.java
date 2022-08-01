package ccom.sample.controller;

import ccom.sample.entity.EmployeeEntity;
import ccom.sample.entity.EmployeeRecords;
import ccom.sample.service.EmployeeService;
import ccom.sample.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class EmployeeController {
    @Autowired
    private IEmployeeService iEmployeeService;

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/insert")
    public String insert(@RequestBody EmployeeEntity employee) {
        return employeeService.insert(employee);
    }

    @GetMapping("/getAll")
    public List<EmployeeEntity> getAllData() {
        return employeeService.getAllData();
    }

    @GetMapping("/get")
    public List<EmployeeRecords> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("/employee/{pageNo}/{pageSize}/{sortBy}")
    public List<EmployeeEntity> getpaginated(@PathVariable int pageNo, @PathVariable int pageSize, @PathVariable String sortBy) {
        return iEmployeeService.findpaginated(pageNo, pageSize, sortBy);
    }

    @GetMapping("/get/acceptingRecords/{pageNo}/{pageSize}")
    public List<Object[]> getpagination(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
        return employeeService.getByColumnName(pageNo, pageSize);
    }

    @GetMapping("/get/rejectingRecords/{pageNo}/{pageSize}")
    public List<Object[]> findpagination(@PathVariable("pageNo") int pageNo, @PathVariable("pageSize") int pageSize) {
        return employeeService.findByColumnName(pageNo, pageSize);
    }


}

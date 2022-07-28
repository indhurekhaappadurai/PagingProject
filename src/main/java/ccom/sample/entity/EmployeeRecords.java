package ccom.sample.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "mock_data")
public class EmployeeRecords {

    @Id
    private  int    employeeId;
    private  String acceptingRecords;
    private  String rejectingRecords;

}

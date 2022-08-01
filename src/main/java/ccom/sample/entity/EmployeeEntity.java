package ccom.sample.entity;


import lombok.Data;


import javax.persistence.*;

@Entity
@Data
@Table(name = "Employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;
    private String employeeName;
    private int employeeAge;
    private String employeeAddress;


}

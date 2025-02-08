package princy.practical1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class Appi{
    public static void main(String[] args) {
        // Load Spring context
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // Get the EmployeeDAO bean
        EmployeeDAO employeeDAO = context.getBean(EmployeeDAO.class);

        // Fetch all employees using ResultSetExtractor
        List<Employee> employees = employeeDAO.getAllEmployeesUsingResultSetExtractor();

        // Print the employee records
        System.out.println("Employee Records:");
        for (Employee emp : employees) {
            System.out.println("ID: " + emp.getEmpId() + ", Name: " + emp.getName() +
                               ", Designation: " + emp.getDesignation() + ", Salary: " + emp.getSalary());
        }
    }
}


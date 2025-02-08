package princy.practical1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Employee> getAllEmployeesUsingResultSetExtractor() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, new ResultSetExtractor<List<Employee>>() {
            @Override
            public List<Employee> extractData(ResultSet rs) throws SQLException {
                List<Employee> employees = new ArrayList<>();
                while (rs.next()) {
                    Employee employee = new Employee();
                    employee.setEmpId(rs.getInt("empId"));
                    employee.setName(rs.getString("Name"));
                    employee.setDesignation(rs.getString("Designation"));
                    employee.setSalary(rs.getDouble("Salary"));
                    employees.add(employee);
                }
                return employees;
            }
        });
    }
}

package application ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

 
public class JDBCMySQLDemo {
    public static void main(String[] args) {        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the EmployeeID:");
         
        int employeeId;
        try {
            employeeId = Integer.parseInt(br.readLine());
            JDBCMySQLDemo demo = new JDBCMySQLDemo();
            Employee employee = demo.getEmployee(employeeId);
            System.out.println(employee);           
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }       
    }
 
    public Employee getEmployee(int employeeId)  {      
        ResultSet rs = null;
        Connection connection = null;
        Statement statement = null; 
         
        Employee employee = null;
        String query = "SELECT * FROM employee WHERE emp_id=" + employeeId;
        try {           
            connection = JDBCMySQLConnection.getConnection();
            statement = connection.createStatement();
            rs = statement.executeQuery(query);
             
            if (rs.next()) {
                employee = new Employee();
//                employee.setEmpId(rs.getInt("emp_id"));
//                employee.setEmpName(rs.getString("emp_name"));
//                employee.setDob(rs.getDate("dob"));
//                employee.setSalary(rs.getDouble("salary"));
//                employee.setDeptId((rs.getInt("dept_id")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return employee;
    }
}
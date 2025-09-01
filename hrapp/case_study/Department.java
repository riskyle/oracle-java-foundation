package hrapp.case_study;

import io.helidon.common.http.Http;
import io.helidon.webserver.Handler;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;

public class Department implements Handler{
	private static final int MAX_EMPLOYEE = 10;
	private String name;
	private Employee[] employees = new Employee[10];
	private int lastAddedEmployeeIndex = -1;
	
	Department(String name) {
		this.name = name;
	}
	
	@Override
	public void accept(ServerRequest req, ServerResponse res) {
		res.status(Http.Status.OK_200);
		
		res.headers().put("Content-Type: text/plain; charset=UTF-8");
		
		StringBuilder builder = new StringBuilder();
		
		for(Employee employee : getEmployees()) {
			builder.append(employee);
		}
		
		res.send(builder);
	}
	
	@Override
	public String toString() {
		return "This is the Department of " + name;
	}
	
	public void addEmployee(Employee employee) {
		if(employees.length > MAX_EMPLOYEE) {
			System.out.println("Department of " + name + " cannot exceed employees up to " + MAX_EMPLOYEE);
		}else {
			lastAddedEmployeeIndex++;
			employees[lastAddedEmployeeIndex] = employee;
		}
	}
	
	public Employee[] getEmployees() {
		Employee[] filterEmployees = new Employee[lastAddedEmployeeIndex + 1];
		
		for(int i = 0; i < filterEmployees.length; i++) {
			filterEmployees[i] = employees[i];
		}
		
		return filterEmployees;
	}
	
	public int getTotalEmployees() {
		return getEmployees().length;
	}
	
	public double getTotalSalary() {
		double total = 0.0;
		for(Employee employee : getEmployees()) {
			total += employee.getSalary();
		}
		return total;
	}
	
	public int getAverageSalary() {
		int avg = 0;			
		if(lastAddedEmployeeIndex != -1) {
			avg = (int) (getTotalSalary() / lastAddedEmployeeIndex+1);
		}
		return avg;
	}
	
	public Employee findEmployee(int id) {
		Employee retObj = null;
		
		if(lastAddedEmployeeIndex == -1) {
			for(Employee employee : getEmployees()) {
				if(employee.getId() == id) {
					retObj = employee;
				}
			}			
		}
		
		return retObj;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
}	

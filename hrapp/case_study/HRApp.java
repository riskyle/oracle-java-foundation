package hrapp.case_study;

import java.util.Arrays;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class HRApp {

	public static void main(String[] args) {
//		add an API the Helidon
		System.out.println("The HRApp is starting");
		
		Department dep = new Department("Budget and Management");
		System.out.println(dep);

		Employee emp = new Employee(1 ,"Christian Kyle", 32.0);
		Employee emp1 = new Employee(3 , "Jee Ann", 0);
		
		dep.addEmployee(emp);
		dep.addEmployee(emp1);
		
		try {			
			System.out.println(dep.findEmployee(1).toString());
		}catch(NullPointerException e) {
			System.out.println("Empty Employees");
		}
		
		for(Employee employee : dep.getEmployees()) {
			System.out.println(employee);
		}
		
		System.out.println("Total Salary on " + dep.getName() + " " + dep.getTotalSalary());
		
		System.out.println("Average Salary on " + dep.getName() + " " + dep.getAverageSalary());

		try {
			Routing routing = Routing
					.builder()
					.get("/employees", dep)
					.build();
			

			ServerConfiguration config = ServerConfiguration
					.builder()
					.bindAddress(InetAddress.getLocalHost())
					.port(3005)
					.build();
			
			WebServer ws = WebServer.create(config, routing);
			
			ws.start();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}

}

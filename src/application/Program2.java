package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.DepartmentDAO;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		DepartmentDAO departmentDAO = DAOFactory.createDepartmentDAO();
		System.out.println("====== TEST 1 Department insert");
		Department dep = new Department(null, "Groceries");
		departmentDAO.insert(dep);
		System.out.println("Inserted! id = " + dep.getId());
		
		
		System.out.println("====== TEST 2 Department update");
		dep.setName("Pharmacy");
		departmentDAO.update(dep);
		System.out.println("updated");
		
		System.out.println("====== TEST 3 Department delete");
		departmentDAO.deleteById(6);
		System.out.println("deleted");
		
		System.out.println("====== TEST 4 Department findById");
		Department dep2 = departmentDAO.findById(3);
		System.out.println(dep2);
		sc.close();
		
		System.out.println("====== TEST 5 Department findAll");
		List<Department> departments = departmentDAO.findAll();
		for (Department d : departments) System.out.println(d);
	}

}

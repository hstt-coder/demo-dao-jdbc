package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {		
		Scanner sc = new Scanner(System.in);
		
		
		SellerDAO sellerDAO = DAOFactory.createSellerDAO();
		
		System.out.println("====== TEST 1: seller findById =======");
		Seller seller = sellerDAO.findById(3);
		
		System.out.println(seller);
		
		System.out.println("====== TEST 2: seller findByDepartment =======");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(dep);
		
		for (Seller s : list) 
			System.out.println(s);
		
		System.out.println("\n====== TEST 3: seller findAll =======");
		List<Seller> list2 = sellerDAO.findAll();
		
		for (Seller s : list2) System.out.println(s);
		
		System.out.println("\n====== TEST 4: seller Insert =======");
		Seller seller4 = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.00, dep);
		sellerDAO.insert(seller4);
		System.out.println("INSERTED! id = " + seller4.getId());
		
		System.out.println("\n====== TEST 5: seller update =======");
		seller = sellerDAO.findById(1);
		seller.setName("Martha Waine");
		seller.setBaseSalary(40343.34);
		sellerDAO.update(seller);
		System.out.println("Updated!");
		
		System.out.println("\n====== TEST 6: seller delete =======");
		System.out.println("Enter id for delete test");
		int id = sc.nextInt();
		sellerDAO.deleteById(id);
		System.out.println("Deleted!");
		
		
		
	
		sc.close();
	}
}

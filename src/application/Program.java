package application;

import java.util.List;

import model.dao.DAOFactory;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {		
		
		SellerDAO sellerDAO = DAOFactory.createSellerDAO();
		
		System.out.println("====== TEST 1: seller findById =======");
		Seller seller = sellerDAO.findById(3);
		
		System.out.println(seller);
		
		System.out.println("====== TEST 2: seller findByDepartment =======");
		Department dep = new Department(2, null);
		List<Seller> list = sellerDAO.findByDepartment(dep);
		
		for (Seller s : list) 
			System.out.println(s);
		
		System.out.println("\n====== TEST 3: seller findAll=======");
		List<Seller> list2 = sellerDAO.findAll();
		
		for (Seller s : list2) 
			System.out.println(s);
	}
}

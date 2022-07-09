package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDAO;
import model.entities.Department;
import model.entities.Seller;

public class SellerDAOJDBC implements SellerDAO{
	private Connection conn;
	
	public SellerDAOJDBC(Connection conn) {
		this.conn = conn;
	}
	
	@Override
	public void insert(Seller obj) {
	
		
	}

	@Override
	public void update(Seller obj) {
		
		
	}

	@Override
	public void deleteById(Integer id) {
		
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT s.*, d.Name as DepartmentName FROM seller s "
					+ "INNER JOIN department d "
					+ "ON s.DepartmentId = d.Id "
					+ "where s.Id = ?;");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if (rs.next()) {
				Department dep = instantiateDepartment(rs);
				Seller seller = instatiateSeller(rs, dep);
				
				return seller;
			} 
			return null;
		} catch(SQLException e) {
			throw new DbException(e.getMessage());
		} finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

	private Seller instatiateSeller(ResultSet rs, Department dep) throws SQLException{
		Seller seller = new Seller();
		seller.setId(rs.getInt("Id"));
		seller.setName(rs.getString("Name"));
		seller.setEmail(rs.getString("Email"));
		seller.setBaseSalary(rs.getDouble("BaseSalary"));
		seller.setBirthDate(rs.getDate("BirthDate"));
		seller.setDepartment(dep);
		
		return seller;
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		
		Department dep = new Department();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepartmentName"));
		
		return dep;
	}

	@Override
	public List<Seller> findAll() {
		return null;
	}
}

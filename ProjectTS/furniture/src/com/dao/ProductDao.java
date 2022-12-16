package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public class ProductDao {
	public static List<String> getAllCategories() throws SQLException, ClassNotFoundException {
		Connection con = DaoUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select distinct(category) from product");
		ResultSet rs = ps.executeQuery();
		List<String> cList = new ArrayList<String>();
		while (rs.next()) {
			cList.add(rs.getString(1));
		}
		return cList;
	}

	public static List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		Connection con = DaoUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from product");
		ResultSet rs = ps.executeQuery();
		List<Product> pList = new ArrayList<>();
		Product p = null;
		while (rs.next()) {
			p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getInt(3));
			p.setImageUrl(rs.getString(4));
			p.setCategory(rs.getString(5));

			pList.add(p);
		}
		return pList;
	}

	public static List<Product> getProductsByCategory(String cat) throws ClassNotFoundException, SQLException {
		Connection con = DaoUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from product where category=?");
		ps.setString(1, cat);
		ResultSet rs = ps.executeQuery();
		List<Product> pList = new ArrayList<>();
		Product p = null;
		while (rs.next()) {
			p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getInt(3));
			p.setImageUrl(rs.getString(4));
			p.setCategory(rs.getString(5));
			pList.add(p);
		}
		return pList;
	}
	
	public  static Product getProductById(int id) throws ClassNotFoundException, SQLException{
		Connection con = DaoUtility.getConnection();
		PreparedStatement ps = con.prepareStatement("select * from product where id=?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		Product p = null;
		while(rs.next()){
			p = new Product();
			p.setId(rs.getInt(1));
			p.setName(rs.getString(2));
			p.setPrice(rs.getInt(3));
			p.setImageUrl(rs.getString(4));
			p.setCategory(rs.getString(5));
		}
		return p;
	}

}

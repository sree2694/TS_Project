package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.User;

public class UserDao {
	public static boolean register(User user) throws ClassNotFoundException, SQLException {
		Connection con = DaoUtility.getConnection();
		PreparedStatement ps = con
				.prepareStatement("insert into user(name,email,password) values(?,?,aes_encrypt(?,'k1'))");
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getPassword());
		int val = ps.executeUpdate();
		if (val != 0) {
			return true;
		}

		return false;
	}

	public static boolean isUserExists(User user) throws ClassNotFoundException, SQLException {
		Connection c = DaoUtility.getConnection();
		PreparedStatement ps = c.prepareStatement("select * from user where email=?");
		ps.setString(1, user.getEmail());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			return true;
		}
		return false;
	}

	public static String getPasswordByEmail(String email) throws ClassNotFoundException, SQLException {
		Connection c = DaoUtility.getConnection();
		PreparedStatement ps = c.prepareStatement("select aes_decrypt(password,'k1') from user where email=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();
		String pwd = null;
		while (rs.next()) {
			pwd = rs.getString(1);
		}
		System.out.println(pwd);
		return pwd;
	}

	public static String getNameByEmail(String email) throws ClassNotFoundException, SQLException {
		Connection c = DaoUtility.getConnection();
		PreparedStatement ps = c.prepareStatement("select name from user where email=?");
		ps.setString(1, email);
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			return rs.getString(1);
		}
		return null;
	}

	public static User getUserByName(String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection c = DaoUtility.getConnection();
		PreparedStatement ps = c.prepareStatement("select * from user where name=?");
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		User u = null;
		while (rs.next()) {
			u = new User();
			u.setId(rs.getInt(1));
			u.setName(rs.getString(2));
			u.setEmail(rs.getString(3));
			u.setPassword(rs.getString(4));
		}
		return u;
	}
	

}

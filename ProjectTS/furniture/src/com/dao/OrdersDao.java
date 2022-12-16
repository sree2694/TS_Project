package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.model.Orders;

public class OrdersDao {

	public static boolean generateOrder(Orders o) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DaoUtility.getConnection();
		System.out.println(o);
		PreparedStatement ps = con
				.prepareStatement("insert into orders(user_id,total_amount,order_date) values(?,?,?)");
		ps.setInt(1, o.getCustId().getId());
		ps.setInt(2, o.getTotalAmount());
		ps.setDate(3, new java.sql.Date(o.getOrderDate().getTime()));
		int i = ps.executeUpdate();
		if (i != 0) {
			return true;
		}
		return false;
	}

	public static int getBillIdWithOrders(int cid, int tamount, Date odate) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		Connection con = DaoUtility.getConnection();
		PreparedStatement ps = con
				.prepareStatement("select id from orders where user_id=? and total_amount=? and order_date=?");
		ps.setInt(1, cid);
		ps.setInt(2, tamount);
		ps.setDate(3, new java.sql.Date(odate.getTime()));

		ResultSet rs = ps.executeQuery();
		int oId = 0;
		while (rs.next()) {
			oId = rs.getInt(1);
		}
		return oId;

	}

}

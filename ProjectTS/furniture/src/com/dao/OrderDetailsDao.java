package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.OrderDetails;

public class OrderDetailsDao {
	public static boolean insertPurchasedItems(OrderDetails od) throws ClassNotFoundException, SQLException {
		Connection con = DaoUtility.getConnection();
		PreparedStatement ps = con
				.prepareStatement("insert into order_details(order_id,product_id,quantity) values(?,?,?)");
	
		ps.setInt(1, od.getOrderId().getId());
		ps.setInt(2, od.getProductId().getId());
		ps.setInt(3, od.getQuantity());
		int i = ps.executeUpdate();
		if (i != 0) {
			return true;
		}
		return false;
	}
	
}

package com.service;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.dao.UserDao;
import com.dao.OrderDetailsDao;
import com.dao.OrdersDao;
import com.dao.ProductDao;
import com.model.User;
import com.model.OrderDetails;
import com.model.Orders;
import com.model.Product;

public class FurnitureService {
	public static List<String> getCategories() throws ClassNotFoundException, SQLException {
		return ProductDao.getAllCategories();
	}

	public static List<Product> getAllProducts() throws ClassNotFoundException, SQLException {
		return ProductDao.getAllProducts();
	}

	public static List<Product> getProductsByCategory(String c) throws ClassNotFoundException, SQLException {
		return ProductDao.getProductsByCategory(c);
	}

	public static boolean register(User user) throws ClassNotFoundException, SQLException {
		return UserDao.register(user);
	}

	public static boolean isUserExists(User user) throws ClassNotFoundException, SQLException {
		return UserDao.isUserExists(user);
	}

	public static String getPasswordByEmail(String email) throws ClassNotFoundException, SQLException {
		return UserDao.getPasswordByEmail(email);
	}

	public static String getNameByEmail(String email) throws ClassNotFoundException, SQLException {
		return UserDao.getNameByEmail(email);
	}

	public static Product getProductById(int id) throws ClassNotFoundException, SQLException {
		return ProductDao.getProductById(id);
	}
	public static User getUidByName(String name) throws ClassNotFoundException, SQLException {
		return UserDao.getUserByName(name);
	}

	public static boolean generateOrder(Orders o) throws ClassNotFoundException, SQLException {
		return OrdersDao.generateOrder(o);
	}

	public static int getBillIdWithOrders(int custId, int totalAmount, Date orderDate) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return OrdersDao.getBillIdWithOrders(custId, totalAmount, orderDate);
	}

	public static boolean insertPurchasedItems(OrderDetails od) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		return OrderDetailsDao.insertPurchasedItems(od);
	}

}

package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.service.FurnitureService;
import com.model.OrderDetails;
import com.model.OrderDetails;
import com.model.Orders;
import com.model.Product;

public class FurnitureController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String rehome = request.getParameter("rehome");
		String rehome1 = request.getParameter("rehome1");
		HttpSession session = request.getSession();
		if (action == null|| action == rehome|| action == rehome1) {
			try {
				List<String> cList = FurnitureService.getCategories();
				session.setAttribute("categoryList", cList);

				List<Product> iList = FurnitureService.getAllProducts();
				session.setAttribute("productList", iList);
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bt = request.getParameter("action");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		if (bt.equals("Go")) {
			String selCategory = request.getParameter("category");
			List<Product> iList;
			try {
				iList = FurnitureService.getProductsByCategory(selCategory);
				session.setAttribute("productList", iList);
				request.getRequestDispatcher("login.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (bt.equals("Register")) {
			String name = request.getParameter("name");
			String email = request.getParameter("E-mail");
			String pwd = request.getParameter("Password");
			User ct = new User();
			ct.setName(name);
			ct.setEmail(email);
			ct.setPassword(pwd);
			try {
				if (!FurnitureService.isUserExists(ct)) {
					if (FurnitureService.register(ct)) {
						request.getRequestDispatcher("register.jsp").forward(request, response);
					}
				}
			} catch (ClassNotFoundException | SQLException e) {
				System.out.println("Exception in controller");
				e.printStackTrace();
			}

		} else if (bt.equals("Login")) {
			String email = request.getParameter("E-mail");
			String pwd = request.getParameter("Password");
			String p;
			try {
				p = FurnitureService.getPasswordByEmail(email);
				if (p.equals(pwd)) {
					session.setAttribute("user", FurnitureService.getNameByEmail(email));
					request.getRequestDispatcher("loginhome.jsp").forward(request, response);
				} else {
					System.out.println("Wrong pwd");
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception in controller");
				e.printStackTrace();
			}

		} else if (bt.equals("GO")) {
			String selCategory = request.getParameter("category");
			List<Product> iList;
			try {
				iList = FurnitureService.getProductsByCategory(selCategory);
				session.setAttribute("productList", iList);
				request.getRequestDispatcher("loginhome.jsp").forward(request, response);

			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if (bt.equals("AddToCart")) {

			LinkedHashMap<Integer, Integer> productDetails = new LinkedHashMap<>();
			int qty = 0, iId = 0;
			int totalPrice = 0;

			// out.print("no of items " + itemDetails.size());
			List<Product> productList = new ArrayList<>();
			List qtList = new ArrayList<>();

			if (session.getAttribute("SelectedProductList") != null) {
				productList = (List<Product>) session.getAttribute("SelectedProductList");
				qtList = (List) session.getAttribute("qtList");
				totalPrice = (int) session.getAttribute("tp");
				String qt[] = request.getParameterValues("qty");
				String id[] = request.getParameterValues("iId");
				for (int i = 0; i < id.length && i < qt.length; i++) {
					qty = Integer.parseInt(qt[i]);
					iId = Integer.parseInt(id[i]);
					productDetails.put(iId, qty);
				}
				for (Map.Entry<Integer, Integer> mp : productDetails.entrySet()) {
					int quantity = mp.getValue();
					if (quantity > 0) {
						qtList.add(quantity);
						int productId = mp.getKey();
						try {
							Product product = FurnitureService.getProductById(productId);
							productList.add(product);
							totalPrice += (quantity * product.getPrice());

						} catch (ClassNotFoundException | SQLException e) {

						}

					}
				}

			} else {
				String qt[] = request.getParameterValues("qty");
				String id[] = request.getParameterValues("iId");
				for (int i = 0; i < id.length && i < qt.length; i++) {
					qty = Integer.parseInt(qt[i]);
					iId = Integer.parseInt(id[i]);
					productDetails.put(iId, qty);
				}
				for (Map.Entry<Integer, Integer> mp : productDetails.entrySet()) {
					int quantity = mp.getValue();
					if (quantity > 0) {
						qtList.add(quantity);
						int productId = mp.getKey();
						try {
							Product product = FurnitureService.getProductById(productId);
							productList.add(product);
							totalPrice += (quantity * product.getPrice());

						} catch (ClassNotFoundException | SQLException e) {

						}

					}
				}
			} // end of else

			session.setAttribute("qtList", qtList);
			session.setAttribute("SelectedProductList", productList);
			session.setAttribute("tp", totalPrice);
			request.getRequestDispatcher("cart.jsp").forward(request, response);

		} // end of addtocart
		else if (bt.equals("Continue")) {
			String uname = (String) session.getAttribute("user");
			Orders o = new Orders();
			try {
				User u = FurnitureService.getUidByName(uname);
				o.setCustId(u);
				int tp = (int) session.getAttribute("tp");
				o.setTotalAmount(tp);
				java.util.Date date = new java.util.Date();
				o.setOrderDate(date);
				if (FurnitureService.generateOrder(o) == true) {
					int oId = FurnitureService.getBillIdWithOrders(u.getId(), tp, date);
					o.setId(oId);
					OrderDetails od = null;

					List<Product> pList = (List<Product>) session.getAttribute("SelectedProductList");
					List qList = (List) session.getAttribute("qtList");

					for (int i = 0; i < pList.size() && i < qList.size(); i++) {
						od = new OrderDetails();
						od.setOrderId(o);
						od.setProductId(pList.get(i));
						od.setQuantity((int) qList.get(i));
						System.out.println(FurnitureService.insertPurchasedItems(od));
			
					}
					request.getRequestDispatcher("final.jsp").forward(request, response);

				} else
					out.print("Not entered");

			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}

		}

	}// end of dopost

}// end of servlet

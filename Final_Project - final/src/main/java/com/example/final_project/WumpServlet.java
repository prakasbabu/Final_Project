package com.example.final_project;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet("/")
public class WumpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private WumpDao wumpDao;
	
	public void init() {
		wumpDao = new WumpDao();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();

		try {
			switch (action) {
			case "/new":
				showNewForm(request, response);
				break;
			case "/insert":
				insertData(request, response);
				break;
			case "/delete":
				deleteData(request, response);
				break;
			case "/edit":
				showEditForm(request, response);
				break;
			case "/update":
				updateData(request, response);
				break;
			case "/logout":
					logoutData(request, response);
					break;

			default:
				listData(request, response);
				break;
			}
		} catch (SQLException ex) {
			throw new ServletException(ex);
		}
	}

	private void listData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException, ServletException {
		List<Data> listUser = wumpDao.selectAllUsers();
		request.setAttribute("listUser", listUser);
		RequestDispatcher dispatcher = request.getRequestDispatcher("data-list.jsp");
		dispatcher.forward(request, response);
	}

	private void showNewForm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("data-form.jsp");
		dispatcher.forward(request, response);
	}

	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Data existingUser = wumpDao.selectUser(id);
		RequestDispatcher dispatcher = request.getRequestDispatcher("data-form.jsp");
		request.setAttribute("user", existingUser);
		dispatcher.forward(request, response);

	}

	private void insertData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		String area = request.getParameter("area");
		String temperature =request.getParameter("temperature");
		int x = 0;
		if(area!=null){
			try{
				x = Integer.parseInt(area);
			}catch(Exception ignored){
			}

		}
		int y = 0;
		if(temperature!=null){
			try{
				y = Integer.parseInt(temperature);
			}catch(Exception ignored){
			}

		}
		String longitude = request.getParameter("longitude");

		int z = 0;
		if(longitude!=null){
			try{
				z = Integer.parseInt(longitude);
			}catch(Exception ignored){
			}

		}
		String latitude = request.getParameter("latitude");
		int l =0;
		if(latitude!=null){
			try{
				l = Integer.parseInt(latitude);
			}catch(Exception ignored){
			}

		}

		String object = request.getParameter("object");
		String weather = request.getParameter("weather");
		Data newUser = new Data(x,object,y,z,l,weather);
		wumpDao.insertUser(newUser);
		response.sendRedirect("list");
	}

	private void updateData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		int area = Integer.parseInt(request.getParameter("area"));
		String object = request.getParameter("object");
		int temperature = Integer.parseInt(request.getParameter("temperature"));
		int longitude = Integer.parseInt(request.getParameter("longitude"));
		int latitude = Integer.parseInt(request.getParameter("latitude"));
		String weather = request.getParameter("weather");

		Data book = new Data(id, area,object,temperature,longitude,latitude,weather);
		wumpDao.updateUser(book);
		response.sendRedirect("list");
	}

	private void deleteData(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		wumpDao.deleteUser(id);
		response.sendRedirect("list");

	}

	public void logoutData(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
		if (session != null){
			session.removeAttribute("list");
			RequestDispatcher dispatcher = request.getRequestDispatcher("validatelogin.jsp");
			dispatcher.forward(request, response);
		}
	}
}
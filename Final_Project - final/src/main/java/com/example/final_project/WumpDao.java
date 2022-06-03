package com.example.final_project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class WumpDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/userdb?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Root1234";

	private static final String INSERT = "INSERT INTO objects" + "  (area,object,temperature,longitude,latitude,weather) VALUES "
			+ " (?, ?, ?,?,?,?);";

	private static final String SELECT = "select id,area,object,temperature,longitude,latitude,weather from objects where id =?";
	private static final String SELECT_ALL = "select * from objects";
	private static final String DELETE = "delete from objects where id = ?;";
	private static final String UPDATE = "update objects set area =?,object =?,temperature =?,longitude =?,latitude =?,weather =? where id=?;";

	public WumpDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertUser(Data user) throws SQLException {
		System.out.println(INSERT);
		try (Connection connection = getConnection();
			 PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
			preparedStatement.setInt(1, user.getArea());
			preparedStatement.setString(2, user.getObject());
			preparedStatement.setInt(3, user.getTemperature());
			preparedStatement.setInt(4, user.getLongitude());
			preparedStatement.setInt(5, user.getLatitude());
			preparedStatement.setString(6, user.getWeather());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Data selectUser(int id) {
		Data user = null;

		try (Connection connection = getConnection();

			 	PreparedStatement preparedStatement = connection.prepareStatement(SELECT);) {
				preparedStatement.setInt(1, id);

				ResultSet rs = preparedStatement.executeQuery();

					while (rs.next()) {

				int area = rs.getInt("area");
				String object = rs.getString("object");
				int temperature = rs.getInt("temperature");
				int longitude = rs.getInt("longitude");
				int latitude = rs.getInt("latitude");
				String weather = rs.getString("weather");
				user = new Data(id, area,object,temperature,longitude,latitude,weather);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return user;
	}

	public List<Data> selectAllUsers() {

		List<Data> users = new ArrayList<>();

		try (Connection connection = getConnection();

			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL);) {

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				int area = rs.getInt("area");
				String object = rs.getString("object");
				int temperature = rs.getInt("temperature");
				int longitude = rs.getInt("longitude");
				int latitude = rs.getInt("latitude");
				String weather = rs.getString("weather");
				users.add(new Data(id, area,object,temperature,longitude,latitude,weather));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return users;
	}

	public boolean deleteUser(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateUser(Data user) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE);) {
			System.out.println("updated data:"+statement);
			statement.setInt(1, user.getArea());
			statement.setString(2, user.getObject());
			statement.setInt(3, user.getTemperature());
			statement.setInt(4, user.getLongitude());
			statement.setInt(5, user.getLatitude());
			statement.setString(6, user.getWeather());
			statement.setInt(7, user.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}
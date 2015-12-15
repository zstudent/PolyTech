package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBExample1 {

	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/Group2", "root", "");
			System.out.println(connection.getClass().getName());

			Statement statement = connection.createStatement();

			ResultSet resultSet = statement
					.executeQuery("select login, id, password  from Users");

			print(resultSet);

			authorize("pooh", "admin", statement);

			// statement.executeUpdate("...");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void authorize(String login, String pass, Statement statement)
			throws SQLException {
		ResultSet result = statement.executeQuery("select * from Users where login='" + login
				+ "' and password = '" + pass + "'");
		if (result.isBeforeFirst()) {
			System.out.println("Welcome, " + login);
		} else {
			System.out.println("Unknown login or wrong password");
		}
	}

	private static void print(ResultSet resultSet) throws SQLException {

		ResultSetMetaData metaData = resultSet.getMetaData();
		int numColumns = metaData.getColumnCount();

		for (int i = 1; i <= numColumns; i++) {
			System.out.print(metaData.getColumnName(i) + " ");
		}
		System.out.println();

		while (resultSet.next()) {
			for (int i = 1; i <= numColumns; i++) {
				System.out.print(resultSet.getString(i) + " ");
			}
			System.out.println();
		}
	}

}

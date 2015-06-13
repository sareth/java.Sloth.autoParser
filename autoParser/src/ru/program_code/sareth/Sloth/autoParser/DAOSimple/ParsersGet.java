package ru.program_code.sareth.Sloth.autoParser.DAOSimple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class ParsersGet {
	private static Connection dbConnection = null;
	private static PreparedStatement preparedStatement = null;
	private static String stringQuery = "SELECT * FROM Positions.parsers";
	
	public static List<ParserObject> getParsers() throws SQLException{
		List<ParserObject> result= new LinkedList<ParserObject>();
		
		String selectSQL =	stringQuery;
		try {
			
			new Connector();
			dbConnection = Connector.getDBConnection();
			preparedStatement = dbConnection.prepareStatement(selectSQL);
			//preparedStatement.setInt(1, 1001);
 
			// execute select SQL stetement
			ResultSet rs = preparedStatement.executeQuery();
 
			while (rs.next()) {
				result.add(new ParserObject(rs.getInt("id"),rs.getString("URL")));
			}
 
		} catch (SQLException e) {
 
			System.out.println(e.getMessage());
 
		} finally {
 
			if (preparedStatement != null) {
				preparedStatement.close();
			}
 
			if (dbConnection != null) {
				dbConnection.close();
			}
 
		}
 
	
	if (result.isEmpty()) return null;
	
	return result;
		
	}
}

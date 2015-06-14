package ru.program_code.sareth.Sloth.autoParser.DAOSimple;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;

public class SiteQueryPositionsImpl implements SiteQueryPositionsIface {
	private Connection dbConnection = null;
	private Statement preparedStatement = null;

	public static void insertList(LinkedList<SiteQueryPositionObject> sqList) {
		printMessageStartUpdate();
		for (SiteQueryPositionObject siteQueryPositionObject : sqList) {
			new SiteQueryPositionsImpl()
					.insertPositons(siteQueryPositionObject);
		}
		printMessageupdated();
	}

	private static void printMessageStartUpdate() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(); 
		System.out.println("Data base update was started at " + dateFormat.format(date));
	}

	private static void printMessageupdated() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println();
		System.out.println("Data base updated at " + dateFormat.format(date));		
	}

	@Override
	public void insertPositons(SiteQueryPositionObject sq) {
		LocalDateTime ldt = sq.getDatetime();
		Instant instant = ldt.atZone(ZoneId.systemDefault()).toInstant();
		Date res = Date.from(instant);
		Timestamp sDate = convertUtilToSql(res);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		String insertSQL = "INSERT INTO positions "
				+ "(positions.searchquery,positions.date,positions.position)"
				+ " Values (" 
				+ sq.getId() + ", '" 
				+ sdf.format(sDate) + "'," 
				+ sq.getPosition()
				+ ")";

		try {

			new Connector();
			dbConnection = Connector.getDBConnection();
			preparedStatement = dbConnection.createStatement();

			preparedStatement.executeUpdate(insertSQL);
			
		} catch (SQLException e) {

			System.out.println(e.getMessage());

		} finally {

			try {
				dbConnection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	private static Timestamp convertUtilToSql(java.util.Date uDate) {

		Timestamp sDate = new Timestamp(uDate.getTime());

		return sDate;

	}

}

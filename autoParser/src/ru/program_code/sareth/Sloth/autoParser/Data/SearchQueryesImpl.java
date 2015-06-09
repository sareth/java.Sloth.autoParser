package ru.program_code.sareth.Sloth.autoParser.Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class SearchQueryesImpl implements SearchQueryesIface {
	private Connection dbConnection = null;
	private PreparedStatement preparedStatement = null;
	@Override
	public List<SearchQueryes> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SearchQueryes getElementById(int id) throws SQLException {
		SearchQueryes result;
		String selectSQL =	"SELECT sitequeryes.Id as Id, sites.ID as siteID, sites.URL as Url, queryes.ID as queryID, "+
							"queryes.Text as Text, languages.Value as LangID, languages.Name as LangName, regions.Value as RegionID, " +
							"regions.Name as RegionName, searchsystems.Value as SearchSystem, searchsystems.Name as SearchSystemName " +
							"FROM Positions.sitequeryes INNER JOIN sites ON sitequeryes.site = sites.ID " +
							"INNER JOIN queryes " +
							"ON (sitequeryes.query = queryes.id) " +
							"INNER JOIN regions " +
							"ON (sitequeryes.region = regions.id) " +
							"INNER JOIN languages " +
							"ON (sitequeryes.lang = languages.id) " +
							"INNER JOIN searchsystems " +
							"ON (sitequeryes.searchsystem = searchsystems.id) " +
							"WHERE sitequeryes.id= " + id;
	 
			try {
				
				new Connector();
				dbConnection = Connector.getDBConnection();
				preparedStatement = dbConnection.prepareStatement(selectSQL);
				//preparedStatement.setInt(1, 1001);
	 
				// execute select SQL stetement
				ResultSet rs = preparedStatement.executeQuery();
	 
				while (rs.next()) {
					int rowid = rs.getInt("Id");
					int siteid = rs.getInt("siteID");
					String url = rs.getString("Url");
					int queryID = rs.getInt("queryID");
					String text = rs.getString("Text");
					int LangID = rs.getInt("LangID");
					String LangName = rs.getString("LangName");
					int RegionID = rs.getInt("RegionID");
					String RegionName = rs.getString("RegionName");
					int SearchSystem = rs.getInt("SearchSystem");
					String SearchSystemName = rs.getString("SearchSystemName");
					result  = new SearchQueryes(rowid, siteid, url, queryID, text, LangID, LangName, RegionID, RegionName, SearchSystem, SearchSystemName);
					
					return result;
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
	 
		
		
		return null;
	}

	@Override
	public List<SearchQueryes> getElementsWhereEveryDay() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SearchQueryes> getElementsWhereEveryWeek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SearchQueryes> getElementsWhereEveryMonth() {
		// TODO Auto-generated method stub
		return null;
	}

}

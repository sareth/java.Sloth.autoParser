package ru.program_code.sareth.Sloth.autoParser.DAOSimple;

import java.sql.SQLException;
import java.util.List;

public interface SearchQueryesGettingResultsIface {
	public List<SearchQueryesObject> getAll() throws SQLException;
	public SearchQueryesObject getElementById(int id) throws SQLException ;
	public List<SearchQueryesObject> getElementsWhereEveryDay() throws SQLException;
	public List<SearchQueryesObject> getElementsWhereEveryWeek() throws SQLException;
	public List<SearchQueryesObject> getElementsWhereEveryMonth() throws SQLException;
}

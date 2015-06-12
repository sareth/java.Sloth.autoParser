package ru.program_code.sareth.Sloth.autoParser.Data;

import java.sql.SQLException;
import java.util.List;

public interface SearchQueryesGettingResultsIface {
	public List<SearchQueryesModelClass> getAll() throws SQLException;
	public SearchQueryesModelClass getElementById(int id) throws SQLException ;
	public List<SearchQueryesModelClass> getElementsWhereEveryDay() throws SQLException;
	public List<SearchQueryesModelClass> getElementsWhereEveryWeek() throws SQLException;
	public List<SearchQueryesModelClass> getElementsWhereEveryMonth() throws SQLException;
}

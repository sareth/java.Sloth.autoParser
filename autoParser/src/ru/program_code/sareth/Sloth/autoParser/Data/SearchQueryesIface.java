package ru.program_code.sareth.Sloth.autoParser.Data;

import java.sql.SQLException;
import java.util.List;

public interface SearchQueryesIface {
	public List<SearchQueryes> getAll();
	public SearchQueryes getElementById(int id) throws SQLException ;
	public List<SearchQueryes> getElementsWhereEveryDay();
	public List<SearchQueryes> getElementsWhereEveryWeek();
	public List<SearchQueryes> getElementsWhereEveryMonth();
}

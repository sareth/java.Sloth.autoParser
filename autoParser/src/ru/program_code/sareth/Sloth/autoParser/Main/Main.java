package ru.program_code.sareth.Sloth.autoParser.Main;
import java.sql.SQLException;

import ru.program_code.sareth.Sloth.autoParser.Data.*;

public class Main {

	public static void main(String[] args) throws SQLException {
		SearchQueryesImpl a = new SearchQueryesImpl();
		SearchQueryes b = a.getElementById(1);
		System.out.println(b.getURL() + " Миша какуля");
	}

}

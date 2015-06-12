package ru.program_code.sareth.Sloth.autoParser.Parser;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import ru.program_code.sareth.Sloth.autoParser.DAOSimple.ParserObject;
import ru.program_code.sareth.Sloth.autoParser.DAOSimple.ParsersGet;
import ru.program_code.sareth.Sloth.autoParser.DAOSimple.SearchQueryesObject;

public class SendHandler {
	//
	/*
	 * 
	 * www.program-code.ru/parse/position_parser.php?query=QUERY&url=URL
	 * &ses=SEARCHSYSTEM&cnt=COUNTRY&lang=LANG&rep=REP&reg=REGION
	 * 
	 * 
	 * 
	*/
	//
	
	public static void buildURLString(SearchQueryesObject sq, String parserURL)
	{
		String getURLstring = "";
		StringBuilder sb = new StringBuilder();
		sb.append(parserURL);
		sb.append("?");
		sb.append("query=");
		sb.append(sq.getText());
		sb.append("&url=");
		sb.append(sq.getURL());
		sb.append("&ses=");
		sb.append(sq.getSearchSystem());
		sb.append("&cnt=");
		sb.append(sq.getCountryValue());
		sb.append("&lang=");
		sb.append(sq.getLangId());
		sb.append("&rep=0");//repeats 0
		sb.append("&reg=");
		sb.append(sq.getRegionId());
		
		getURLstring=sb.toString();
		System.out.print(getURLstring);
	}
	/*
	 * LinkedList<ParserObject> parsersList = (LinkedList<ParserObject>) ParsersGet.getParsers();
		int searchSystemId = sq.getSearchSystemId();
				
		for (Iterator<ParserObject> iterator = parsersList.iterator(); iterator.hasNext();) {
			ParserObject parserObject = (ParserObject) iterator.next();
			if (parserObject.getSearchSystemId()==searchSystemId)
		}
	 */
	
}

package ru.program_code.sareth.Sloth.autoParser.Parser;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import ru.program_code.sareth.Sloth.autoParser.DAOSimple.ParserObject;
import ru.program_code.sareth.Sloth.autoParser.DAOSimple.ParsersGet;
import ru.program_code.sareth.Sloth.autoParser.DAOSimple.SearchQueryesObject;
import ru.program_code.sareth.Sloth.autoParser.DAOSimple.SiteQueryPositionObject;

public class SendStringURLHandler {
	//
	/*
	 * 
	 * www.program-code.ru/parse/position_parser.php?query=QUERY&url=URL
	 * &ses=SEARCHSYSTEM&cnt=COUNTRY&lang=LANG&rep=REP&reg=REGION
	 */
	//
	public static List<SiteQueryPositionObject> buildURLLists(
			LinkedList<SearchQueryesObject> sitequeryes) throws SQLException {
		
		LinkedList<SiteQueryPositionObject> result = new LinkedList<SiteQueryPositionObject>();
		
		LinkedList<SearchQueryesObject> queryes = sitequeryes;// это LinkedList<SearchQueryesObject>
		LinkedList<ParserObject> parsers = (LinkedList<ParserObject>) ParsersGet
				.getParsers();
		int index = 0;
		
		if (parsers.isEmpty()==false){
			
			for (SearchQueryesObject searchQueryesObject : queryes) {
				String request = buildURLString(searchQueryesObject,parsers.get(index).getURL());
				int response = SendMessage.Send(request);
				if (response==-1)
					{
					result.add(new SiteQueryPositionObject(searchQueryesObject.getSiteID(), searchQueryesObject.getURL(),
							searchQueryesObject.getQueryId(), searchQueryesObject.getText(), searchQueryesObject.getSearchSystemId(),
							searchQueryesObject.getSearchSystemName(), searchQueryesObject.getRegionId(), searchQueryesObject.getLangId(), 
							response, request, LocalDateTime.now()));
					index = ((index+1)<(parsers.size())) ? index+1 : 0 ;
				}
				else
				{
					do
					{
						index = ((index+1)<(parsers.size())) ? index+1 : 0 ;
						request = buildURLString(searchQueryesObject,parsers.get(index).getURL());
						response = SendMessage.Send(request);
					}while(response==-1);
					
					result.add(new SiteQueryPositionObject(searchQueryesObject.getSiteID(), searchQueryesObject.getURL(),
							searchQueryesObject.getQueryId(), searchQueryesObject.getText(), searchQueryesObject.getSearchSystemId(),
							searchQueryesObject.getSearchSystemName(), searchQueryesObject.getRegionId(), searchQueryesObject.getLangId(), 
							response, request, LocalDateTime.now()));
				}
				//System.out.println(request + " " + response);
			}
			return result;
		}
		

		return null;
	}

	public static String buildURLString(SearchQueryesObject sq, String parserURL) {
		String getURLstring = "";
		StringBuilder sb = new StringBuilder();
		sb.append(parserURL);
		sb.append("?");
		sb.append("query=");
		String query = sq.getText();
		try {
			sb.append(URLEncoder.encode(query, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		sb.append("&url=");
		sb.append(sq.getURL());
		sb.append("&ses=");
		sb.append(sq.getSearchSystem());
		sb.append("&cnt=");
		sb.append(sq.getCountryValue());
		sb.append("&lang=");
		sb.append(sq.getLangId());
		sb.append("&rep=0");// repeats 0
		sb.append("&reg=");
		sb.append(sq.getRegionId());

		getURLstring = sb.toString();
		
		return (getURLstring);
	}
	/*
	 * LinkedList<ParserObject> parsersList = (LinkedList<ParserObject>)
	 * ParsersGet.getParsers(); int searchSystemId = sq.getSearchSystemId();
	 * 
	 * for (Iterator<ParserObject> iterator = parsersList.iterator();
	 * iterator.hasNext();) { ParserObject parserObject = (ParserObject)
	 * iterator.next(); if (parserObject.getSearchSystemId()==searchSystemId) }
	 */

}

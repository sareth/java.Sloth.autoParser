package ru.program_code.sareth.Sloth.autoParser.Main;

import java.util.LinkedList;

import ru.program_code.sareth.Sloth.autoParser.DAOSimple.SearchQueryesGettingResultsImpl;
import ru.program_code.sareth.Sloth.autoParser.DAOSimple.SearchQueryesObject;
import ru.program_code.sareth.Sloth.autoParser.DAOSimple.SiteQueryPositionObject;
import ru.program_code.sareth.Sloth.autoParser.DAOSimple.SiteQueryPositionsImpl;
import ru.program_code.sareth.Sloth.autoParser.Parser.SendStringURLHandler;

public class ResultHandler {
	public static void handleArgs(String[] args){
		try {
			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("-all")) {
					SearchQueryesGettingResultsImpl a = new SearchQueryesGettingResultsImpl();

					LinkedList<SearchQueryesObject> b = (LinkedList<SearchQueryesObject>) a
							.getAll();
					if (b.isEmpty() == false) {
						LinkedList<SiteQueryPositionObject> ss = (LinkedList<SiteQueryPositionObject>) SendStringURLHandler.buildURLLists(b);
						new SiteQueryPositionsImpl();
						SiteQueryPositionsImpl.insertList(ss);
					} else {
						System.out.print("No records found");
					}
				}
				else if (args[0].equalsIgnoreCase("-daily")) {
					SearchQueryesGettingResultsImpl a = new SearchQueryesGettingResultsImpl();

					LinkedList<SearchQueryesObject> b = (LinkedList<SearchQueryesObject>) a
							.getElementsWhereEveryDay();
					if (b.isEmpty() == false) {
						LinkedList<SiteQueryPositionObject> ss = (LinkedList<SiteQueryPositionObject>) SendStringURLHandler.buildURLLists(b);
						new SiteQueryPositionsImpl();
						SiteQueryPositionsImpl.insertList(ss);
					} else {
						System.out.print("No records found");
					}
				}
				else if (args[0].equalsIgnoreCase("-weekly")) {
					SearchQueryesGettingResultsImpl a = new SearchQueryesGettingResultsImpl();

					LinkedList<SearchQueryesObject> b = (LinkedList<SearchQueryesObject>) a
							.getElementsWhereEveryWeek();
					if (b.isEmpty() == false) {
						LinkedList<SiteQueryPositionObject> ss = (LinkedList<SiteQueryPositionObject>) SendStringURLHandler.buildURLLists(b);
						new SiteQueryPositionsImpl();
						SiteQueryPositionsImpl.insertList(ss);

					} else {
						System.out.print("No records found");
					}
				}
				else if (args[0].equalsIgnoreCase("-monthly")) {
					SearchQueryesGettingResultsImpl a = new SearchQueryesGettingResultsImpl();

					LinkedList<SearchQueryesObject> b = (LinkedList<SearchQueryesObject>) a
							.getElementsWhereEveryMonth();
					if (b.isEmpty() == false) {
						LinkedList<SiteQueryPositionObject> ss = (LinkedList<SiteQueryPositionObject>) SendStringURLHandler.buildURLLists(b);
						new SiteQueryPositionsImpl();
						SiteQueryPositionsImpl.insertList(ss);

					} else {
						System.out.print("No records found");
					}
				}
			} else if (args.length == 2) {
				if ((args[0].equalsIgnoreCase("-id")) & (args[1].length() != 0)) {

					SearchQueryesGettingResultsImpl a = new SearchQueryesGettingResultsImpl();

					int id = (new Integer(args[1]).intValue());

					SearchQueryesObject b = a.getElementById(id);
					if (b !=null) {
						LinkedList<SearchQueryesObject> objQuery = new LinkedList<SearchQueryesObject>();
						objQuery.add(b);
						LinkedList<SiteQueryPositionObject> ss = (LinkedList<SiteQueryPositionObject>) SendStringURLHandler.buildURLLists(objQuery);
						new SiteQueryPositionsImpl();
						SiteQueryPositionsImpl.insertList(ss);
						
					} else {
						System.out.print("Not find");
					}
				}
				else
				{
					printHelp();
				}
			}
		} catch (Exception e) {
			printHelp();
			e.printStackTrace();
		}
		
	}
	private static void printHelp() {
		System.out
				.println("Check syntax, only one parameter can be transmitted at a time and only one value of the parameter may be at:");
		System.out.println("sloth.java -[parameter] [value]");
		System.out.println();
		System.out.println("Values:");
		System.out
				.println("[idvalue] integer value, index of searchquery table row, uses only with parameter -ID");
		System.out
				.println("[-daily] displays all records where the flight schedules of receiving positions on each day");
		System.out
				.println("[-weekly] displays all records where the flight schedules of receiving positions on each week");
		System.out
				.println("[-monthly] displays all records where the flight schedules of receiving positions on each month");
	}
}

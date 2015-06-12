package ru.program_code.sareth.Sloth.autoParser.DAOSimple;

public class ParserObject {
	private int SearchSystemId;
	private String URL;
	
	public int getSearchSystemId() {
		return SearchSystemId;
	}
	public void setSearchSystemId(int searchSystemId) {
		SearchSystemId = searchSystemId;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public ParserObject(int searchSystemId, String uRL) {
		super();
		SearchSystemId = searchSystemId;
		URL = uRL;
	}
	
	
	
}

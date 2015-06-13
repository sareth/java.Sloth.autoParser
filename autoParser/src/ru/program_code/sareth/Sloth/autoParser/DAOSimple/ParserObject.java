package ru.program_code.sareth.Sloth.autoParser.DAOSimple;

public class ParserObject {
	private int parserId;
	private String URL;
	
	public int getParserId() {
		return parserId;
	}
	public void setParserId(int parserId) {
		this.parserId = parserId;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	
	public ParserObject(int searchSystemId, String uRL) {
		super();
		parserId = searchSystemId;
		URL = uRL;
	}
	
	
	
}

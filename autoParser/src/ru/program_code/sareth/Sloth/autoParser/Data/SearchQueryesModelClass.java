package ru.program_code.sareth.Sloth.autoParser.Data;

public class SearchQueryesModelClass {
	protected int id;
	protected int siteID;
	protected String URL;
	protected int queryId;
	protected String Text;
	protected int LangId;
	protected String LangName;
	protected int RegionId;
	protected String RegionName;
	protected int SearchSystem;
	protected String SearchSystemName;
	
	public SearchQueryesModelClass(int id, int siteID, String uRL, int queryId,
			String text, int langId, String langName, int regionId,
			String regionName, int searchSystem, String searchSystemName) {
		super();
		this.id = id;
		this.siteID = siteID;
		URL = uRL;
		this.queryId = queryId;
		Text = text;
		LangId = langId;
		LangName = langName;
		RegionId = regionId;
		RegionName = regionName;
		SearchSystem = searchSystem;
		SearchSystemName = searchSystemName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSiteID() {
		return siteID;
	}
	public void setSiteID(int siteID) {
		this.siteID = siteID;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public int getQueryId() {
		return queryId;
	}
	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}
	public String getText() {
		return Text;
	}
	public void setText(String text) {
		Text = text;
	}
	public int getLangId() {
		return LangId;
	}
	public void setLangId(int langId) {
		LangId = langId;
	}
	public String getLangName() {
		return LangName;
	}
	public void setLangName(String langName) {
		LangName = langName;
	}
	public int getRegionId() {
		return RegionId;
	}
	public void setRegionId(int regionId) {
		RegionId = regionId;
	}
	public String getRegionName() {
		return RegionName;
	}
	public void setRegionName(String regionName) {
		RegionName = regionName;
	}
	public int getSearchSystem() {
		return SearchSystem;
	}
	public void setSearchSystem(int searchSystem) {
		SearchSystem = searchSystem;
	}
	public String getSearchSystemName() {
		return SearchSystemName;
	}
	public void setSearchSystemName(String searchSystemName) {
		SearchSystemName = searchSystemName;
	}
	
	
	

}

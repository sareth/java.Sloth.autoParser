package ru.program_code.sareth.Sloth.autoParser.DAOSimple;

public class SearchQueryesObject {
	protected int id;
	protected int siteID;
	protected String URL;
	protected int queryId;
	protected String Text;
	protected int langValue;
	protected int countryId;
	protected int countryName;
	protected int countryValue;
	protected String LangName;
	protected int RegionId;
	protected String RegionName;
	protected int SearchSystemId;
	protected int SearchSystem;
	protected String SearchSystemName;
	
	public SearchQueryesObject(int id, int siteID, String uRL, int queryId,
			String text, int langValue, String langName, int regionId,
			String regionName, int searchSystem, String searchSystemName, int SearchSystemId, int cntId, int CntValue) {
		super();
		this.id = id;
		this.siteID = siteID;
		URL = uRL;
		this.queryId = queryId;
		Text = text;
		this.langValue = langValue;
		LangName = langName;
		RegionId = regionId;
		RegionName = regionName;
		SearchSystem = searchSystem;
		SearchSystemName = searchSystemName;
		this.SearchSystemId = SearchSystemId;
		this.countryId = cntId;
		this.countryValue = CntValue;
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
		return langValue;
	}
	public void setLangId(int langId) {
		langValue = langId;
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
	public int getSearchSystemId() {
		return SearchSystemId;
	}
	public void setSearchSystemId(int searchSystemId) {
		SearchSystemId = searchSystemId;
	}
	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getCountryName() {
		return countryName;
	}

	public void setCountryName(int countryName) {
		this.countryName = countryName;
	}

	public int getCountryValue() {
		return countryValue;
	}

	public void setCountryValue(int countryValue) {
		this.countryValue = countryValue;
	}
	

}

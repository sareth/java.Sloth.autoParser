package ru.program_code.sareth.Sloth.autoParser.DAOSimple;

import java.time.LocalDateTime;

public class SiteQueryPositionObject {
	private int siteId;
	private String siteName;
	private int queryId;
	private String queryString;
	private int searchSystemId;
	private String searchSystemName;
	private int regionId;
	private int langId;
	private int position;
	private String URLParseString;
	private LocalDateTime datetime;
	
	public SiteQueryPositionObject(int siteId, String siteName, int queryId,
			String queryString, int searchSystemId, String searchSystemName,
			int regionId, int langId, int position, String uRLParseString, LocalDateTime datetime) {
		super();
		this.siteId = siteId;
		this.siteName = siteName;
		this.queryId = queryId;
		this.queryString = queryString;
		this.searchSystemId = searchSystemId;
		this.searchSystemName = searchSystemName;
		this.regionId = regionId;
		this.langId = langId;
		this.position = position;
		URLParseString = uRLParseString;
		this.datetime = datetime;
		
	}
	public int getSiteId() {
		return siteId;
	}
	public void setSiteId(int siteId) {
		this.siteId = siteId;
	}
	public String getSiteName() {
		return siteName;
	}
	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}
	public int getQueryId() {
		return queryId;
	}
	public void setQueryId(int queryId) {
		this.queryId = queryId;
	}
	public String getQueryString() {
		return queryString;
	}
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	public int getSearchSystemId() {
		return searchSystemId;
	}
	public void setSearchSystemId(int searchSystemId) {
		this.searchSystemId = searchSystemId;
	}
	public String getSearchSystemName() {
		return searchSystemName;
	}
	public void setSearchSystemName(String searchSystemName) {
		this.searchSystemName = searchSystemName;
	}
	public int getRegionId() {
		return regionId;
	}
	public void setRegionId(int regionId) {
		this.regionId = regionId;
	}
	public int getLangId() {
		return langId;
	}
	public void setLangId(int langId) {
		this.langId = langId;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getURLParseString() {
		return URLParseString;
	}
	public void setURLParseString(String uRLParseString) {
		URLParseString = uRLParseString;
	}
	public LocalDateTime getDatetime() {
		return datetime;
	}
	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}
	
}

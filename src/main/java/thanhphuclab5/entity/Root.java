package thanhphuclab5.entity;

import java.util.ArrayList;
import java.util.Date;

/// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
//import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root root = om.readValue(myJsonString, Root.class); */
public class Root {
	public String id;
	public String name;
	public String given_name;
	public String family_name;
	public String picture;
	public String locale;
	public Root() {
//		super();
	}
	public Root(String id, String name, String given_name, String family_name, String picture, String locale) {
		super();
		this.id = id;
		this.name = name;
		this.given_name = given_name;
		this.family_name = family_name;
		this.picture = picture;
		this.locale = locale;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGiven_name() {
		return given_name;
	}
	public void setGiven_name(String given_name) {
		this.given_name = given_name;
	}
	public String getFamily_name() {
		return family_name;
	}
	public void setFamily_name(String family_name) {
		this.family_name = family_name;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	@Override
	public String toString() {
		return "Root [id=" + id + ", name=" + name + ", given_name=" + given_name + ", family_name=" + family_name
				+ ", picture=" + picture + ", locale=" + locale + "]";
	}
	
	
	
	
}

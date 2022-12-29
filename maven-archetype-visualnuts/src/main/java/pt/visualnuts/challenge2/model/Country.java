package pt.visualnuts.challenge2.model;

public class Country {

	private String country;
	private String[] languages;

	public Country(String country, String[] languages) {
		super();
		this.country = country;
		this.languages = languages;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String[] getLanguages() {
		return languages;
	}

	public void setLanguages(String[] languages) {
		this.languages = languages;
	}
	
	public int getLanguagesSize() {
		return languages.length;
	}

}

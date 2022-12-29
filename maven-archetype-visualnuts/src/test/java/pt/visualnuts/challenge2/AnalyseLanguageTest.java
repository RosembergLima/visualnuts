package pt.visualnuts.challenge2;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import pt.visualnuts.challenge2.model.Country;
import pt.visualnuts.challenge2.service.CountryService;

@TestInstance(Lifecycle.PER_CLASS)
public class AnalyseLanguageTest {

	private List<Country> countries;

	@BeforeAll
	public void init() {
		Gson gson = new Gson();
		String jsonData = null;
		try {
			jsonData = new String(getClass().getClassLoader().getResourceAsStream("countries.json").readAllBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
		Type dataType = (new TypeToken<List<Country>>() {
		}).getType();
		countries = gson.fromJson(jsonData, dataType);
	}

	@Test
	public void countCountriesInRequest() {
		// Scenario
		CountryService service = new CountryService();

		// Action
		int countCountries = service.getCountCountry(countries);

		// Verify
		assertEquals(5, countCountries);
	}

	@Test
	public void countCountriesWhereDEIsOfficialLanguage() {
		// Scenario
		CountryService service = new CountryService();

		// Action
		List<Country> countriesSpeakDE = service.findOfficialLanguageByLanguage("de", countries);

		// Verify
		assertEquals(2, countriesSpeakDE.size());
	}

	@Test
	public void countOfficialLanguage() {
		// Scenario
		CountryService service = new CountryService();

		// Action
		int officialLanguage = service.countOfficialLanguage(countries);

		// Verify
		assertEquals(6, officialLanguage);
	}

	@Test
	public void countCountryWithHigestOfficialLanguage() {
		// Scenario
		CountryService service = new CountryService();

		// Action
		Country country = service.countCountryWithHigestOfficialLanguage(countries);

		// Verify
		assertEquals("BE", country.getCountry());
	}

	@Test
	public void findMostCommonOfficialLanguages() {
		// Scenario
		CountryService service = new CountryService();

		// Action
		String[] languages = service.findMostCommonOfficialLanguages(countries);

		// Verify
		assertTrue(Arrays.asList(languages).contains("de"));
		assertTrue(Arrays.asList(languages).contains("nl"));	
	}

}

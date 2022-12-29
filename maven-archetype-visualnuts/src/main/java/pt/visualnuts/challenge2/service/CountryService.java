package pt.visualnuts.challenge2.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import pt.visualnuts.challenge2.model.Country;

public class CountryService {

	public int getCountCountry(List<Country> countries) {
		return countries.size();
	}

	public List<Country> findOfficialLanguageByLanguage(String language, List<Country> countries) {
		return countries.stream().filter(c -> Arrays.asList(c.getLanguages()).contains(language))
				.collect(Collectors.toList());
	}

	public int countOfficialLanguage(List<Country> countries) {
		Set<String> languages = new HashSet<String>();
		for (Country country : countries) {
			languages.addAll(Arrays.asList(country.getLanguages()));
		}
		return languages.size();
	}

	public Country countCountryWithHigestOfficialLanguage(List<Country> countries) {
		return countries.stream().max(Comparator.comparingInt(Country::getLanguagesSize)).get();
	}

	public String[] findMostCommonOfficialLanguages(List<Country> countries) {
		List<String> allLanguages = new ArrayList<String>();
		for (Country country : countries) {
			allLanguages.addAll(Arrays.asList(country.getLanguages()));
		}
		Set<String> duplicateCompanies = allLanguages.stream()
				.filter(language -> Collections.frequency(allLanguages, language) > 1).collect(Collectors.toSet());
		return duplicateCompanies.toArray(new String[0]);
	}

}

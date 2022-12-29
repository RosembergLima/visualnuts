package pt.visualnuts.challenge1;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
public class CheckNumberTest {

	private CheckNumber checkNumber;

	@BeforeAll	
	public void init() {
		checkNumber = new CheckNumber();
	}

	@Test
	public void isOnlyDivisibleBy3() {
		// action
		boolean result = checkNumber.isDivisible(3, 3.0);
		// verification
		assertTrue(result);
	}

	@Test
	public void isOnlyDivisibleBy5() {
		// action
		boolean result = checkNumber.isDivisible(5, 5.0);
		// verification
		assertTrue(result);

	}

}

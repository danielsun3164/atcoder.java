package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem084Test extends TestBase {

	@Test
	void case1() {
		check("2 3 9", "No");
	}

	@Test
	void case2() {
		check("2 3 10", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("2020_panasonic/C");
	}
}

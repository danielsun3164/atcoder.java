package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem065Test extends TestBase {

	@Test
	void case1() {
		check("4 5", "10");
	}

	@Test
	void case2() {
		check("7 3", "11");
	}

	@Test
	void case3() {
		check("1000000000 1000000000", "500000000000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("2020_panasonic/B");
	}
}

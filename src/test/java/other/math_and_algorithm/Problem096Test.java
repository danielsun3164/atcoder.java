package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem096Test extends TestBase {

	@Test
	void case1() {
		check("5\n" + "8 3 7 2 5", "13");
	}

	@Test
	void case2() {
		check("2\n" + "1000 1", "1000");
	}

	@Test
	void case3() {
		check("9\n" + "3 14 15 9 26 5 35 89 79", "138");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc204/D");
	}
}

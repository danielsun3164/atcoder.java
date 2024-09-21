package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem094Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 5", "9");
	}

	@Test
	void case2() {
		check("2\n" + "3", "6");
	}

	@Test
	void case3() {
		check("6\n" + "0 153 10 10 23", "53");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC140/C");
	}
}

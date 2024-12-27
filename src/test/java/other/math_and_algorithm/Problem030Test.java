package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem030Test extends TestBase {

	@Test
	void case1() {
		check("3 8\n" + "3 30\n" + "4 50\n" + "5 60", "90");
	}

	@Test
	void case2() {
		check("5 5\n" + "1 1000000000\n" + "1 1000000000\n" + "1 1000000000\n" + "1 1000000000\n" + "1 1000000000",
				"5000000000");
	}

	@Test
	void case3() {
		check("6 15\n" + "6 5\n" + "5 6\n" + "6 4\n" + "6 6\n" + "3 5\n" + "7 2", "17");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("dp/D");
	}
}

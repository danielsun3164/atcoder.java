package other.math_and_algorithm;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem099Test extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 2", "1");
	}

	@Test
	void case2() {
		check("4\n" + "1 2\n" + "1 3\n" + "1 4", "9");
	}

	@Test
	void case3() {
		check("12\n" + "1 2\n" + "3 1\n" + "4 2\n" + "2 5\n" + "3 6\n" + "3 7\n" + "8 4\n" + "4 9\n" + "10 5\n"
				+ "11 7\n" + "7 12", "211");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/039");
	}
}

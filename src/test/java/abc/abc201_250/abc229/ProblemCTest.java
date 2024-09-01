package abc.abc201_250.abc229;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 5\n" + "3 1\n" + "4 2\n" + "2 3", "15");
	}

	@Test
	void case2() {
		check("4 100\n" + "6 2\n" + "1 5\n" + "3 9\n" + "8 7", "100");
	}

	@Test
	void case3() {
		check("10 3141\n" + "314944731 649\n" + "140276783 228\n" + "578012421 809\n" + "878510647 519\n"
				+ "925326537 943\n" + "337666726 611\n" + "879137070 306\n" + "87808915 39\n" + "756059990 244\n"
				+ "228622672 291", "2357689932073");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc229/C");
	}
}

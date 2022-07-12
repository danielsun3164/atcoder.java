package abc.abc101_150.abc120;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 5\n" + "1 2\n" + "3 4\n" + "1 3\n" + "2 3\n" + "1 4", "0" + LF + "0" + LF + "4" + LF + "5" + LF + "6");
	}

	@Test
	void case2() {
		check("6 5\n" + "2 3\n" + "1 2\n" + "5 6\n" + "3 4\n" + "4 5",
				"8" + LF + "9" + LF + "12" + LF + "14" + LF + "15");
	}

	@Test
	void case3() {
		check("2 1\n" + "1 2", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC120/D");
	}
}

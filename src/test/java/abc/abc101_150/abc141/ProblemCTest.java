package abc.abc101_150.abc141;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6 3 4\n" + "3\n" + "1\n" + "3\n" + "2",
				"No" + LF + "No" + LF + "Yes" + LF + "No" + LF + "No" + LF + "No");
	}

	@Test
	void case2() {
		check("6 5 4\n" + "3\n" + "1\n" + "3\n" + "2",
				"Yes" + LF + "Yes" + LF + "Yes" + LF + "Yes" + LF + "Yes" + LF + "Yes");
	}

	@Test
	void case3() {
		check("10 13 15\n" + "3\n" + "1\n" + "4\n" + "1\n" + "5\n" + "9\n" + "2\n" + "6\n" + "5\n" + "3\n" + "5\n"
				+ "8\n" + "9\n" + "7\n" + "9",
				"No" + LF + "No" + LF + "No" + LF + "No" + LF + "Yes" + LF + "No" + LF + "No" + LF + "No" + LF + "Yes"
						+ LF + "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC141/C");
	}
}

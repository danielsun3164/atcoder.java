package abc.abc201_250.abc223;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemH別回答Test extends TestBase {

	@Test
	void case1() {
		check("5 2\n" + "3 1 4 1 5\n" + "1 3 7\n" + "2 5 7", "Yes" + LF + "No");
	}

	@Test
	void case2() {
		check("10 10\n" + "8 45 56 9 38 28 33 5 15 19\n" + "10 10 53\n" + "3 8 60\n" + "1 10 29\n" + "5 7 62\n"
				+ "3 7 51\n" + "8 8 52\n" + "1 4 60\n" + "6 8 32\n" + "4 8 58\n" + "5 9 2",
				"No" + LF + "No" + LF + "Yes" + LF + "No" + LF + "Yes" + LF + "No" + LF + "No" + LF + "No" + LF + "Yes"
						+ LF + "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc223/H");
	}
}

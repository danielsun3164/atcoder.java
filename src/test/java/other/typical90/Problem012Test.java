package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem012Test extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "10\n" + "1 2 2\n" + "1 1 1\n" + "2 1 1 2 2\n" + "1 3 2\n" + "2 1 1 2 2\n" + "2 2 2 3 2\n"
				+ "1 2 3\n" + "1 2 1\n" + "2 1 1 2 2\n" + "2 1 1 3 3",
				"No" + LF + "No" + LF + "Yes" + LF + "Yes" + LF + "No");
	}

	@Test
	void case2() {
		check("1 1\n" + "3\n" + "2 1 1 1 1\n" + "1 1 1\n" + "2 1 1 1 1", "No" + LF + "Yes");
	}

	@Test
	void case3() {
		check("5 5\n" + "42\n" + "2 3 4 3 4\n" + "2 3 2 3 2\n" + "1 4 1\n" + "2 4 1 2 2\n" + "1 1 2\n" + "1 4 5\n"
				+ "1 3 3\n" + "2 4 2 1 3\n" + "1 3 5\n" + "2 2 4 2 3\n" + "2 2 4 2 5\n" + "2 3 4 5 1\n" + "2 3 1 2 2\n"
				+ "2 3 1 1 2\n" + "2 2 4 5 2\n" + "2 3 2 5 3\n" + "1 4 3\n" + "2 3 3 3 5\n" + "2 3 1 3 2\n" + "1 1 5\n"
				+ "2 4 4 5 3\n" + "1 1 4\n" + "2 1 3 2 5\n" + "2 4 3 1 4\n" + "2 2 3 3 3\n" + "1 2 1\n" + "1 2 5\n"
				+ "2 1 4 5 3\n" + "2 4 4 2 5\n" + "2 4 2 2 4\n" + "1 2 2\n" + "2 4 1 5 2\n" + "1 2 4\n" + "2 3 1 4 1\n"
				+ "1 4 4\n" + "2 3 2 2 1\n" + "2 1 1 5 2\n" + "1 4 2\n" + "2 4 2 3 5\n" + "1 3 2\n" + "1 3 4\n"
				+ "1 2 3",
				"No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No"
						+ LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No"
						+ LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF + "No" + LF
						+ "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/012");
	}
}

package abc.abc101_150.abc143;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 2 5\n" + "1 2 3\n" + "2 3 3\n" + "2\n" + "3 2\n" + "1 3", "0" + LF + "1");
	}

	@Test
	void case2() {
		check("4 0 1\n" + "1\n" + "2 1", "-1");
	}

	@Test
	void case3() {
		check("5 4 4\n" + "1 2 2\n" + "2 3 2\n" + "3 4 3\n" + "4 5 2\n" + "20\n" + "2 1\n" + "3 1\n" + "4 1\n" + "5 1\n"
				+ "1 2\n" + "3 2\n" + "4 2\n" + "5 2\n" + "1 3\n" + "2 3\n" + "4 3\n" + "5 3\n" + "1 4\n" + "2 4\n"
				+ "3 4\n" + "5 4\n" + "1 5\n" + "2 5\n" + "3 5\n" + "4 5",
				"0" + LF + "0" + LF + "1" + LF + "2" + LF + "0" + LF + "0" + LF + "1" + LF + "2" + LF + "0" + LF + "0"
						+ LF + "0" + LF + "1" + LF + "1" + LF + "1" + LF + "0" + LF + "0" + LF + "2" + LF + "2" + LF
						+ "1" + LF + "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC143/E");
	}
}

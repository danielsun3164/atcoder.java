package abc.abc201_250.abc218;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2\n" + "1 3\n" + "2 3", "1" + LF + "2" + LF + "1");
	}

	@Test
	void case2() {
		check("4 4\n" + "1 2\n" + "2 3\n" + "2 4\n" + "3 4", "-1" + LF + "2" + LF + "3" + LF + "2");
	}

	@Test
	void case3() {
		check("5 10\n" + "1 2\n" + "1 4\n" + "1 5\n" + "2 1\n" + "2 3\n" + "3 1\n" + "3 2\n" + "3 5\n" + "4 2\n"
				+ "4 3",
				"1" + LF + "1" + LF + "3" + LF + "1" + LF + "1" + LF + "1" + LF + "1" + LF + "1" + LF + "1" + LF + "1");
	}

	@Test
	void case4() {
		check("4 1\n" + "1 2", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc218/F");
	}
}

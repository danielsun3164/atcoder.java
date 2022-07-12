package abc.abc151_200.abc168;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5 6\n" + "1 2 0\n" + "0 1 1\n" + "0 2 2\n" + "-3 4 -1\n" + "-2 6 3\n" + "1 0 1\n" + "0 1 2\n" + "2 0 2\n"
				+ "-1 -4 5\n" + "3 -2 4\n" + "1 2 4", "13");
	}

	@Test
	void case2() {
		check("6 1\n" + "-3 -1 -2\n" + "-3 -1 1\n" + "-2 -1 2\n" + "1 4 -2\n" + "1 4 -1\n" + "1 4 1\n" + "3 1 4",
				"INF");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC168/F");
	}
}

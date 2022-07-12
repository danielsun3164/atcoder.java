package abc.abc151_200.abc163;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2 1\n" + "1 2\n" + "2 3", "5" + LF + "4" + LF + "0");
	}

	@Test
	void case2() {
		check("1\n" + "1", "1");
	}

	@Test
	void case3() {
		check("2\n" + "1 2\n" + "1 2", "2" + LF + "2");
	}

	@Test
	void case4() {
		check("5\n" + "1 2 3 4 5\n" + "1 2\n" + "2 3\n" + "3 4\n" + "3 5",
				"5" + LF + "8" + LF + "10" + LF + "5" + LF + "5");
	}

	@Test
	void case5() {
		check("8\n" + "2 7 2 5 4 1 7 5\n" + "3 1\n" + "1 2\n" + "2 7\n" + "4 5\n" + "5 6\n" + "6 8\n" + "7 8",
				"18" + LF + "15" + LF + "0" + LF + "14" + LF + "23" + LF + "0" + LF + "23" + LF + "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC163/F");
	}
}

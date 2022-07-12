package abc.abc151_200.abc159;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 1 2 1 2", "2" + LF + "2" + LF + "3" + LF + "2" + LF + "3");
	}

	@Test
	void case2() {
		check("4\n" + "1 2 3 4", "0" + LF + "0" + LF + "0" + LF + "0");
	}

	@Test
	void case3() {
		check("5\n" + "3 3 3 3 3", "6" + LF + "6" + LF + "6" + LF + "6" + LF + "6");
	}

	@Test
	void case4() {
		check("8\n" + "1 2 1 4 2 1 4 1",
				"5" + LF + "7" + LF + "5" + LF + "7" + LF + "7" + LF + "5" + LF + "7" + LF + "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC159/D");
	}
}

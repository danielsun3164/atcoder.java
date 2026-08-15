package abc.abc201_250.abc240;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3 2 3 2 2", "1" + LF + "2" + LF + "3" + LF + "4" + LF + "3");
	}

	@Test
	void case2() {
		check("10\n" + "2 3 2 3 3 3 2 3 3 2",
				"1" + LF + "2" + LF + "3" + LF + "4" + LF + "5" + LF + "3" + LF + "2" + LF + "3" + LF + "1" + LF + "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc240/D");
	}
}

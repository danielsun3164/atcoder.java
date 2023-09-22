package abc.abc201_250.abc220;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "2 7 6",
				"1" + LF + "0" + LF + "0" + LF + "0" + LF + "2" + LF + "1" + LF + "0" + LF + "0" + LF + "0" + LF + "0");
	}

	@Test
	void case2() {
		check("5\n" + "0 1 2 3 4",
				"6" + LF + "0" + LF + "1" + LF + "1" + LF + "4" + LF + "0" + LF + "1" + LF + "1" + LF + "0" + LF + "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc220/D");
	}
}

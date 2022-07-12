package abc.abc201_250.abc212;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 3\n" + "1 5\n" + "3\n" + "2 2\n" + "3", "3" + LF + "7");
	}

	@Test
	void case2() {
		check("6\n" + "1 1000000000\n" + "2 1000000000\n" + "2 1000000000\n" + "2 1000000000\n" + "2 1000000000\n"
				+ "3", "5000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc212/D");
	}
}

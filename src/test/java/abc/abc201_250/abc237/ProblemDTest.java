package abc.abc201_250.abc237;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "LRRLR", "1 2 4 5 3 0");
	}

	@Test
	void case2() {
		check("7\n" + "LLLLLLL", "7 6 5 4 3 2 1 0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc237/D");
	}
}

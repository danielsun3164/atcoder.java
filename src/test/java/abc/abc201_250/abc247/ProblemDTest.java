package abc.abc201_250.abc247;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 2 3\n" + "2 2\n" + "1 3 4\n" + "2 3", "4" + LF + "8");
	}

	@Test
	void case2() {
		check("2\n" + "1 1000000000 1000000000\n" + "2 1000000000", "1000000000000000000");
	}

	@Test
	void case3() {
		checkResultIsEmpty("5\n" + "1 1 1\n" + "1 1 1\n" + "1 1 1\n" + "1 1 1\n" + "1 1 1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc247/D");
	}
}

package abc.abc201_250.abc230;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2\n" + "4 7\n" + "5 9", "2");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 2\n" + "4 7\n" + "4 9", "1");
	}

	@Test
	void case3() {
		check("5 2\n" + "1 100\n" + "1 1000000000\n" + "101 1000\n" + "9982 44353\n" + "1000000000 1000000000", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc230/D");
	}
}

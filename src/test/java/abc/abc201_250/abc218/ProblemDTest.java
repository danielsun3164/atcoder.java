package abc.abc201_250.abc218;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "0 0\n" + "0 1\n" + "1 0\n" + "1 1\n" + "2 0\n" + "2 1", "3");
	}

	@Test
	void case2() {
		check("4\n" + "0 1\n" + "1 2\n" + "2 3\n" + "3 4", "0");
	}

	@Test
	void case3() {
		check("7\n" + "0 1\n" + "1 0\n" + "2 0\n" + "2 1\n" + "2 2\n" + "3 0\n" + "3 2", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc218/D");
	}
}

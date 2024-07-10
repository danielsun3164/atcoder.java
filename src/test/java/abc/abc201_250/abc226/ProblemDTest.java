package abc.abc201_250.abc226;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 2\n" + "3 6\n" + "7 4", "6");
	}

	@Test
	void case2() {
		check("3\n" + "1 2\n" + "2 2\n" + "4 2", "2");
	}

	@Test
	void case3() {
		check("4\n" + "0 0\n" + "0 1000000000\n" + "1000000000 0\n" + "1000000000 1000000000", "8");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc226/D");
	}
}

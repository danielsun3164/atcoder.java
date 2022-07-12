package abc.abc201_250.abc210;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 4 2\n" + "1 7 7 9\n" + "9 6 3 7\n" + "7 8 6 4", "10");
	}

	@Test
	void case2() {
		check("3 3 1000000000\n" + "1000000 1000000 1\n" + "1000000 1000000 1000000\n" + "1 1000000 1000000",
				"1001000001");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc210/D");
	}
}

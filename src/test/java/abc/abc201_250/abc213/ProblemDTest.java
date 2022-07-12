package abc.abc201_250.abc213;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 2\n" + "4 2\n" + "3 1", "1 2 4 2 1 3 1");
	}

	@Test
	void case2() {
		check("5\n" + "1 2\n" + "1 3\n" + "1 4\n" + "1 5", "1 2 1 3 1 4 1 5 1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc213/D");
	}
}

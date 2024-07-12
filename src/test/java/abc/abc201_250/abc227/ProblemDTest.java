package abc.abc201_250.abc227;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "2 3 4", "2");
	}

	@Test
	void case2() {
		check("4 2\n" + "1 1 3 4", "4");
	}

	@Test
	void case3() {
		check("4 3\n" + "1 1 3 4", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc227/D");
	}
}

package abc.abc201_250.abc236;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 3 2 3 3 2 2 1 1 1 2", "3");
	}

	@Test
	void case2() {
		check("1\n" + "1 1 1", "1");
	}

	@Test
	void case3() {
		check("4\n" + "3 2 1 1 2 4 4 4 4 3 1 3 2 1 3", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc236/B");
	}
}

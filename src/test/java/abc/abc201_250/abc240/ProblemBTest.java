package abc.abc201_250.abc240;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "1 4 1 2 2 1", "3");
	}

	@Test
	void case2() {
		check("1\n" + "1", "1");
	}

	@Test
	void case3() {
		check("11\n" + "3 1 4 1 5 9 2 6 5 3 5", "7");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc240/B");
	}
}

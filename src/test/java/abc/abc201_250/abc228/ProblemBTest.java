package abc.abc201_250.abc228;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 2\n" + "3 1 1 2", "3");
	}

	@Test
	void case2() {
		check("20 12\n" + "7 11 10 1 7 20 14 2 17 3 2 5 19 20 8 14 18 2 10 10", "7");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc228/B");
	}
}

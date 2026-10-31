package abc.abc201_250.abc248;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("4 1\n" + "1 4 2 3", "9");
	}

	@Test
	void case2() {
		check("2 0\n" + "2 1", "3");
	}

	@Test
	void case3() {
		check("10 3\n" + "3 7 10 1 9 5 4 8 6 2", "37");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc248/Ex");
	}
}

package abc.abc151_200.abc185;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "1 2 1 3\n" + "1 3 1", "2");
	}

	@Test
	void case2() {
		check("4 6\n" + "1 3 2 4\n" + "1 5 2 6 4 3", "3");
	}

	@Test
	void case3() {
		check("5 5\n" + "1 1 1 1 1\n" + "2 2 2 2 2", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC185/E");
	}
}

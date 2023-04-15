package abc.abc201_250.abc218;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 5\n" + "1 2 1\n" + "1 3 1\n" + "1 4 1\n" + "3 2 2\n" + "4 2 2", "4");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 2 1\n" + "2 3 0\n" + "3 1 -1", "1");
	}

	@Test
	void case3() {
		check("2 3\n" + "1 2 -1\n" + "1 2 2\n" + "1 1 3", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc218/E");
	}
}

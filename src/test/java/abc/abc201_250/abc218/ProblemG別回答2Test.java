package abc.abc201_250.abc218;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答2Test extends TestBase {

	@Test
	void case1() {
		check("5\n" + "2 4 6 8 10\n" + "4 5\n" + "3 4\n" + "1 5\n" + "2 4", "7");
	}

	@Test
	void case2() {
		check("5\n" + "6 4 6 10 8\n" + "1 4\n" + "1 2\n" + "1 5\n" + "1 3", "8");
	}

	@Test
	void case3() {
		check("6\n" + "2 2 6 4 6 6\n" + "1 2\n" + "2 3\n" + "4 6\n" + "2 5\n" + "2 6", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc218/G");
	}
}

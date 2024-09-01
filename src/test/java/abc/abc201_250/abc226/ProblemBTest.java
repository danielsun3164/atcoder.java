package abc.abc201_250.abc226;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "2 1 2\n" + "2 1 1\n" + "2 2 1\n" + "2 1 2", "3");
	}

	@Test
	void case2() {
		check("5\n" + "1 1\n" + "1 1\n" + "1 2\n" + "2 1 1\n" + "3 1 1 1", "4");
	}

	@Test
	void case3() {
		check("1\n" + "1 1", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc226/B");
	}
}

package abc.abc201_250.abc235;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 5 10 4 2", "10");
	}

	@Test
	void case2() {
		check("3\n" + "100 1000 100000", "100000");
	}

	@Test
	void case3() {
		check("4\n" + "27 1828 1828 9242", "1828");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc235/B");
	}
}

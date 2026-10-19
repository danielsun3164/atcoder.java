package abc.abc201_250.abc245;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("4 4 2 2\n" + "1 1 2 2\n" + "2 3\n" + "1 2 15\n" + "2 3 30\n" + "3 4 40\n" + "1 4 10", "45 30 30 25");
	}

	@Test
	void case2() {
		check("3 1 3 1\n" + "1 2 3\n" + "1\n" + "1 2 1000000000", "-1 1000000000 -1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc245/G");
	}
}

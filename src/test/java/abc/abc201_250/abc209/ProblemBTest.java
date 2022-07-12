package abc.abc201_250.abc209;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "1 3", "Yes");
	}

	@Test
	void case2() {
		check("4 10\n" + "3 3 4 4", "No");
	}

	@Test
	void case3() {
		check("8 30\n" + "3 1 4 1 5 9 2 6", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc209/B");
	}
}

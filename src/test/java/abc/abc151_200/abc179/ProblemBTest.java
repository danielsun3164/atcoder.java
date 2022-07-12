package abc.abc151_200.abc179;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 2\n" + "6 6\n" + "4 4\n" + "3 3\n" + "3 2", "Yes");
	}

	@Test
	void case2() {
		check("5\n" + "1 1\n" + "2 2\n" + "3 4\n" + "5 5\n" + "6 6", "No");
	}

	@Test
	void case3() {
		check("6\n" + "1 1\n" + "2 2\n" + "3 3\n" + "4 4\n" + "5 5\n" + "6 6", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC179/B");
	}
}

package abc.abc101_150.abc135;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "5 2 3 4 1", "YES");
	}

	@Test
	void case2() {
		check("5\n" + "2 4 3 5 1", "NO");
	}

	@Test
	void case3() {
		check("7\n" + "1 2 3 4 5 6 7", "YES");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC135/B");
	}
}

package abc.abc101_150.abc117;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "3 8 5 1", "Yes");
	}

	@Test
	void case2() {
		check("4\n" + "3 8 4 1", "No");
	}

	@Test
	void case3() {
		check("10\n" + "1 8 10 5 8 12 34 100 11 3", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC117/B");
	}
}

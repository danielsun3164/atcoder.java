package abc.abc051_100.abc097;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10", "9");
	}

	@Test
	void case2() {
		check("1", "1");
	}

	@Test
	void case3() {
		check("999", "961");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC097/B");
	}
}

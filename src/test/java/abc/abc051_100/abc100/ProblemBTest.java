package abc.abc051_100.abc100;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("0 5", "5");
	}

	@Test
	void case2() {
		check("1 11", "1100");
	}

	@Test
	void case3() {
		check("2 85", "850000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC100/B");
	}
}

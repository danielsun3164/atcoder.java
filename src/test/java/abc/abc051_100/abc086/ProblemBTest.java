package abc.abc051_100.abc086;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1 21", "Yes");
	}

	@Test
	void case2() {
		check("100 100", "No");
	}

	@Test
	void case3() {
		check("12 10", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC089/B");
	}
}

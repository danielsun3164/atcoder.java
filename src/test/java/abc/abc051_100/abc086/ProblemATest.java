package abc.abc051_100.abc086;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 4", "Even");
	}

	@Test
	void case2() {
		check("1 21", "Odd");
	}

	@Test
	void case3() {
		check("10000 10000", "Even");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC089/A");
	}
}

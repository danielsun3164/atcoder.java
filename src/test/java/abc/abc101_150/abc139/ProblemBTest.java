package abc.abc101_150.abc139;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 10", "3");
	}

	@Test
	void case2() {
		check("8 9", "2");
	}

	@Test
	void case3() {
		check("8 8", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC139/B");
	}
}

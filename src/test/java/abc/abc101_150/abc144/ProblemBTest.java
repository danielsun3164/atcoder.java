package abc.abc101_150.abc144;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10", "Yes");
	}

	@Test
	void case2() {
		check("50", "No");
	}

	@Test
	void case3() {
		check("81", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC144/B");
	}
}

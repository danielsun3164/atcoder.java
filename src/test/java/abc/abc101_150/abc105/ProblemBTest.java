package abc.abc101_150.abc105;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("11", "Yes");
	}

	@Test
	void case2() {
		check("40", "Yes");
	}

	@Test
	void case3() {
		check("3", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC105/B");
	}
}

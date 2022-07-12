package abc.abc101_150.abc136;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("11", "9");
	}

	@Test
	void case2() {
		check("136", "46");
	}

	@Test
	void case3() {
		check("100000", "90909");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC136/B");
	}
}

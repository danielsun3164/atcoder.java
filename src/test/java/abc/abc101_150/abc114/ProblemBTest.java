package abc.abc101_150.abc114;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1234567876", "34");
	}

	@Test
	void case2() {
		check("35753", "0");
	}

	@Test
	void case3() {
		check("1111111111", "642");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC114/B");
	}
}

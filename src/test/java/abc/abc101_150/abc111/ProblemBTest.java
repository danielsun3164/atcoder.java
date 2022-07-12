package abc.abc101_150.abc111;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("111", "111");
	}

	@Test
	void case2() {
		check("112", "222");
	}

	@Test
	void case3() {
		check("750", "777");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC111/B");
	}
}

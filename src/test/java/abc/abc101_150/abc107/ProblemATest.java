package abc.abc101_150.abc107;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 2", "3");
	}

	@Test
	void case2() {
		check("1 1", "1");
	}

	@Test
	void case3() {
		check("15 11", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC107/A");
	}
}

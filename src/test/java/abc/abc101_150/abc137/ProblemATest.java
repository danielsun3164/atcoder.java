package abc.abc101_150.abc137;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("-13 3", "-10");
	}

	@Test
	void case2() {
		check("1 -33", "34");
	}

	@Test
	void case3() {
		check("13 3", "39");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC137/A");
	}
}

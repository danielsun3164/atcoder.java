package abc.abc051_100.abc066;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("700 600 780", "1300");
	}

	@Test
	void case2() {
		check("10000 10000 10000", "20000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC077/A");
	}
}

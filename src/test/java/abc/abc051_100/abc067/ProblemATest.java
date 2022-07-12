package abc.abc051_100.abc067;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 5", "Possible");
	}

	@Test
	void case2() {
		check("1 1", "Impossible");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC078/A");
	}
}

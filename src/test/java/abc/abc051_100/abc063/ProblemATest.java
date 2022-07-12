package abc.abc051_100.abc063;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("6 3", "9");
	}

	@Test
	void case2() {
		check("6 4", "error");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC075/A");
	}
}

package abc.abc051_100.abc090;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 2", "7");
	}

	@Test
	void case2() {
		check("10 0", "100");
	}

	@Test
	void case3() {
		check("31415 9265", "287927211");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC091/D");
	}
}

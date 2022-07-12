package abc.abc051_100.abc095;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("oxo", "900");
	}

	@Test
	void case2() {
		check("ooo", "1000");
	}

	@Test
	void case3() {
		check("xxx", "700");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC096/A");
	}
}

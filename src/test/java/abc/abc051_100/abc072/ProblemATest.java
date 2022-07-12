package abc.abc051_100.abc072;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("100 17", "83");
	}

	@Test
	void case2() {
		check("48 58", "0");
	}

	@Test
	void case3() {
		check("1000000000 1000000000", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC082/A");
	}
}

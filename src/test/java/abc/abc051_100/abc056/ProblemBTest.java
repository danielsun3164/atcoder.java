package abc.abc051_100.abc056;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 2 6", "1");
	}

	@Test
	void case2() {
		check("3 1 3", "0");
	}

	@Test
	void case3() {
		check("5 10 1", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC070/B");
	}
}

package abc.abc051_100.abc056;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("H H", "H");
	}

	@Test
	void case2() {
		check("D H", "D");
	}

	@Test
	void case3() {
		check("D D", "H");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC070/A");
	}
}

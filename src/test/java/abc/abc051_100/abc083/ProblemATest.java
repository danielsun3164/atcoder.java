package abc.abc051_100.abc083;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 8 7 1", "Left");
	}

	@Test
	void case2() {
		check("3 4 5 2", "Balanced");
	}

	@Test
	void case3() {
		check("1 7 6 4", "Right");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC088/A");
	}
}

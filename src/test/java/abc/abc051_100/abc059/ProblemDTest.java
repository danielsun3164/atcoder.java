package abc.abc051_100.abc059;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 1", "Brown");
	}

	@Test
	void case2() {
		check("5 0", "Alice");
	}

	@Test
	void case3() {
		check("0 0", "Brown");
	}

	@Test
	void case4() {
		check("4 8", "Alice");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC072/D");
	}
}

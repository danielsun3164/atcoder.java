package abc.abc051_100.abc094;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 5 4", "YES");
	}

	@Test
	void case2() {
		check("2 2 6", "NO");
	}

	@Test
	void case3() {
		check("5 3 2", "NO");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC095/A");
	}
}

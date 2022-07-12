package abc.abc051_100.abc058;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 4 6", "YES");
	}

	@Test
	void case2() {
		check("2 5 6", "NO");
	}

	@Test
	void case3() {
		check("3 2 1", "YES");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC071/A");
	}
}

package abc.abc051_100.abc068;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 2\n" + "2 3", "POSSIBLE");
	}

	@Test
	void case2() {
		check("4 3\n" + "1 2\n" + "2 3\n" + "3 4", "IMPOSSIBLE");
	}

	@Test
	void case3() {
		check("100000 1\n" + "1 99999", "IMPOSSIBLE");
	}

	@Test
	void case4() {
		check("5 5\n" + "1 3\n" + "4 5\n" + "2 3\n" + "2 4\n" + "1 4", "POSSIBLE");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC079/C");
	}
}

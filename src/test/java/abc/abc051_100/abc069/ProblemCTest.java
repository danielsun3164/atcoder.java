package abc.abc051_100.abc069;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 10 100", "Yes");
	}

	@Test
	void case2() {
		check("4\n" + "1 2 3 4", "No");
	}

	@Test
	void case3() {
		check("3\n" + "1 4 1", "Yes");
	}

	@Test
	void case4() {
		check("2\n" + "1 1", "No");
	}

	@Test
	void case5() {
		check("6\n" + "2 7 1 8 2 8", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC080/C");
	}
}

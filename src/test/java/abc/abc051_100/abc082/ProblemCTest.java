package abc.abc051_100.abc082;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "3 3 3 3", "1");
	}

	@Test
	void case2() {
		check("5\n" + "2 4 1 4 2", "2");
	}

	@Test
	void case3() {
		check("6\n" + "1 2 2 3 3 3", "0");
	}

	@Test
	void case4() {
		check("1\n" + "1000000000", "1");
	}

	@Test
	void case5() {
		check("8\n" + "2 7 1 8 2 8 1 8", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC087/C");
	}
}

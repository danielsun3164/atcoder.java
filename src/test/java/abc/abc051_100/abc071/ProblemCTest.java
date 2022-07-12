package abc.abc051_100.abc071;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "3 1 2 4 2 1", "2");
	}

	@Test
	void case2() {
		check("4\n" + "1 2 3 4", "0");
	}

	@Test
	void case3() {
		check("10\n" + "3 3 3 3 4 4 4 5 5 5", "20");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC081/C");
	}
}

package abc.abc051_100.abc062;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 5", "0");
	}

	@Test
	void case2() {
		check("4 5", "2");
	}

	@Test
	void case3() {
		check("5 5", "4");
	}

	@Test
	void case4() {
		check("100000 2", "1");
	}

	@Test
	void case5() {
		check("100000 100000", "50000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC074/C");
	}
}

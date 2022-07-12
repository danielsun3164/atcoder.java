package abc.abc051_100.abc086;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "0 1 W\n" + "1 2 W\n" + "5 3 B\n" + "5 4 B", "4");
	}

	@Test
	void case2() {
		check("2 1000\n" + "0 0 B\n" + "0 1 W", "2");
	}

	@Test
	void case3() {
		check("6 2\n" + "1 2 B\n" + "2 1 W\n" + "2 2 B\n" + "1 0 B\n" + "0 6 W\n" + "4 5 W", "4");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC089/D");
	}
}

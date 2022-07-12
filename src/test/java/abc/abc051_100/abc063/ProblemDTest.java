package abc.abc051_100.abc063;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4 5 3\n" + "8\n" + "7\n" + "4\n" + "2", "2");
	}

	@Test
	void case2() {
		check("2 10 4\n" + "20\n" + "20", "4");
	}

	@Test
	void case3() {
		check("5 2 1\n" + "900000000\n" + "900000000\n" + "1000000000\n" + "1000000000\n" + "1000000000", "800000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC075/D");
	}
}

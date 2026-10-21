package abc.abc201_250.abc246;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 4 7\n" + "8 3 10 5 13", "12");
	}

	@Test
	void case2() {
		check("5 100 7\n" + "8 3 10 5 13", "0");
	}

	@Test
	void case3() {
		check("20 815 60\n"
				+ "2066 3193 2325 4030 3725 1669 1969 763 1653 159 5311 5341 4671 2374 4513 285 810 742 2981 202",
				"112");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc246/C");
	}
}

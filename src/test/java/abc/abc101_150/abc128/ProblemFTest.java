package abc.abc101_150.abc128;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "0 2 5 1 0", "3");
	}

	@Test
	void case2() {
		check("6\n" + "0 10 -7 -4 -13 0", "0");
	}

	@Test
	void case3() {
		check("11\n" + "0 -4 0 -99 31 14 -15 -39 43 18 0", "59");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC128/F");
	}
}

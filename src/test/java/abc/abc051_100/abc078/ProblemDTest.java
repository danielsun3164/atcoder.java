package abc.abc051_100.abc078;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 100 100\n" + "10 1000 100", "900");
	}

	@Test
	void case2() {
		check("3 100 1000\n" + "10 100 100", "900");
	}

	@Test
	void case3() {
		check("5 1 1\n" + "1 1 1 1 1", "0");
	}

	@Test
	void case4() {
		check("1 1 1\n" + "1000000000", "999999999");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC085/D");
	}
}

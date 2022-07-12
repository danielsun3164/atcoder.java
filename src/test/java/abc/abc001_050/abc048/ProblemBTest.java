package abc.abc001_050.abc048;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 8 2", "3");
	}

	@Test
	void case2() {
		check("0 5 1", "6");
	}

	@Test
	void case3() {
		check("9 9 2", "0");
	}

	@Test
	void case4() {
		check("1 1000000000000000000 3", "333333333333333333");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC064/B");
	}
}

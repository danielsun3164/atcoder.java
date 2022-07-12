package abc.abc151_200.abc198;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答1Test extends TestBase {

	@Test
	void case1() {
		check("8", "3");
	}

	@Test
	void case2() {
		check("9", "5");
	}

	@Test
	void case3() {
		check("50", "80132");
	}

	@Test
	void case4() {
		check("10000000000", "2239716");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc198/F");
	}
}

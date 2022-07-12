package abc.abc151_200.abc184;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 0\n" + "xox", "0");
	}

	@Test
	void case2() {
		check("20 199999\n" + "oooooooooxoooooooooo", "200017");
	}

	@Test
	void case3() {
		check("20 10\n" + "xxxxxxxxxxxxxxxxxxxx", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC184/B");
	}
}

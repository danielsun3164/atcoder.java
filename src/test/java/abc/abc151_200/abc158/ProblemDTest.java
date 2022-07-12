package abc.abc151_200.abc158;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("a\n" + "4\n" + "2 1 p\n" + "1\n" + "2 2 c\n" + "1", "cpa");
	}

	@Test
	void case2() {
		check("a\n" + "6\n" + "2 2 a\n" + "2 1 b\n" + "1\n" + "2 2 c\n" + "1\n" + "1", "aabc");
	}

	@Test
	void case3() {
		check("y\n" + "1\n" + "2 1 x", "xy");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC158/D");
	}
}

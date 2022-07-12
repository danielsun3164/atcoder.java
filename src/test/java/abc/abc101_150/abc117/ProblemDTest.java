package abc.abc101_150.abc117;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 7\n" + "1 6 3", "14");
	}

	@Test
	void case2() {
		check("4 9\n" + "7 4 0 3", "46");
	}

	@Test
	void case3() {
		check("1 0\n" + "1000000000000", "1000000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC117/D");
	}
}

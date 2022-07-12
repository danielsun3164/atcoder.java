package abc.abc051_100.abc100;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 4", "Yay!");
	}

	@Test
	void case2() {
		check("8 8", "Yay!");
	}

	@Test
	void case3() {
		check("11 4", ":(");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC100/A");
	}
}

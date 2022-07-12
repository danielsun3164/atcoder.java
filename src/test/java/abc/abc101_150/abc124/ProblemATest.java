package abc.abc101_150.abc124;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 3", "9");
	}

	@Test
	void case2() {
		check("3 4", "7");
	}

	@Test
	void case3() {
		check("6 6", "12");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC124/A");
	}
}

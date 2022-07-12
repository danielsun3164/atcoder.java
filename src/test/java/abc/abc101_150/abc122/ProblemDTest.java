package abc.abc101_150.abc122;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3", "61");
	}

	@Test
	void case2() {
		check("4", "230");
	}

	@Test
	void case3() {
		check("100", "388130742");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC122/D");
	}
}

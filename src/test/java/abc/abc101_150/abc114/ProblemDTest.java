package abc.abc101_150.abc114;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("9", "0");
	}

	@Test
	void case2() {
		check("10", "1");
	}

	@Test
	void case3() {
		check("100", "543");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC114/D");
	}
}

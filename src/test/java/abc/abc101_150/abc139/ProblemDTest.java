package abc.abc101_150.abc139;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2", "1");
	}

	@Test
	void case2() {
		check("13", "78");
	}

	@Test
	void case3() {
		check("1", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC139/D");
	}
}

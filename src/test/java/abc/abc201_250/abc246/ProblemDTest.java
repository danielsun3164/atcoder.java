package abc.abc201_250.abc246;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("9", "15");
	}

	@Test
	void case2() {
		check("0", "0");
	}

	@Test
	void case3() {
		check("999999999989449206", "1000000000000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc246/D");
	}
}

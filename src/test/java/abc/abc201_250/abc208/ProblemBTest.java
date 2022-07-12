package abc.abc201_250.abc208;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("9", "3");
	}

	@Test
	void case2() {
		check("119", "10");
	}

	@Test
	void case3() {
		check("10000000", "24");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc208/B");
	}
}

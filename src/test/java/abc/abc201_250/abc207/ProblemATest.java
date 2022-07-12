package abc.abc201_250.abc207;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 4 5", "9");
	}

	@Test
	void case2() {
		check("6 6 6", "12");
	}

	@Test
	void case3() {
		check("99 99 98", "198");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc207/A");
	}
}

package abc.abc201_250.abc226;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3.456", "3");
	}

	@Test
	void case2() {
		check("99.500", "100");
	}

	@Test
	void case3() {
		check("0.000", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc226/A");
	}
}

package abc.abc151_200.abc175;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("RRS", "2");
	}

	@Test
	void case2() {
		check("SSS", "0");
	}

	@Test
	void case3() {
		check("RSR", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC175/A");
	}
}

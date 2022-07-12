package abc.abc151_200.abc164;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 5", "unsafe");
	}

	@Test
	void case2() {
		check("100 2", "safe");
	}

	@Test
	void case3() {
		check("10 10", "unsafe");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC164/A");
	}
}

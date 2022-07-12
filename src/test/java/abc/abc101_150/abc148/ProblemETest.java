package abc.abc101_150.abc148;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("12", "1");
	}

	@Test
	void case2() {
		check("5", "0");
	}

	@Test
	void case3() {
		check("1000000000000000000", "124999999999999995");
	}

	@Test
	void case4() {
		check("52", "6");
	}

	@Test
	void case5() {
		check("252", "31");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC148/E");
	}
}

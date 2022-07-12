package abc.abc151_200.abc196;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("33", "3");
	}

	@Test
	void case2() {
		check("1333", "13");
	}

	@Test
	void case3() {
		check("10000000", "999");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC196/C");
	}
}

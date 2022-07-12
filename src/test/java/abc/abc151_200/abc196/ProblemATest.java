package abc.abc151_200.abc196;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("0 10\n" + "0 10", "10");
	}

	@Test
	void case2() {
		check("-100 -100\n" + "100 100", "-200");
	}

	@Test
	void case3() {
		check("-100 100\n" + "-100 100", "200");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC196/A");
	}
}

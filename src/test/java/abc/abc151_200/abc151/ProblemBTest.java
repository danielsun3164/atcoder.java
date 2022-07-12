package abc.abc151_200.abc151;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5 10 7\n" + "8 10 3 6", "8");
	}

	@Test
	void case2() {
		check("4 100 60\n" + "100 100 100", "0");
	}

	@Test
	void case3() {
		check("4 100 60\n" + "0 0 0", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC151/B");
	}
}

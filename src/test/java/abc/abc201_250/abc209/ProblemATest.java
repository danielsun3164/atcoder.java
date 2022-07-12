package abc.abc201_250.abc209;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 4", "3");
	}

	@Test
	void case2() {
		check("10 100", "91");
	}

	@Test
	void case3() {
		check("3 2", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc209/A");
	}
}

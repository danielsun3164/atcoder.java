package abc.abc201_250.abc205;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 3 1", "9");
	}

	@Test
	void case2() {
		check("1 0 0", "0");
	}

	@Test
	void case3() {
		check("1000000 1000000 1000000", "192151600");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc205/E");
	}
}

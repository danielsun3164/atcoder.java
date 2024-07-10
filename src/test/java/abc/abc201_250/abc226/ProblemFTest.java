package abc.abc201_250.abc226;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("2 2", "5");
	}

	@Test
	void case2() {
		check("3 3", "79");
	}

	@Test
	void case3() {
		check("50 10000", "77436607");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc226/F");
	}
}

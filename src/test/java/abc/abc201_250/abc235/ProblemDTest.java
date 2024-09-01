package abc.abc201_250.abc235;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 72", "4");
	}

	@Test
	void case2() {
		check("2 5", "-1");
	}

	@Test
	void case3() {
		check("2 611", "12");
	}

	@Test
	void case4() {
		check("2 767090", "111");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc235/D");
	}
}

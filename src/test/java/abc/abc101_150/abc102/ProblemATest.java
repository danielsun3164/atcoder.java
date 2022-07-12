package abc.abc101_150.abc102;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3", "6");
	}

	@Test
	void case2() {
		check("10", "10");
	}

	@Test
	void case3() {
		check("999999999", "1999999998");
	}

	@Test
	void case4() {
		check("1000000000", "1000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC102/A");
	}
}

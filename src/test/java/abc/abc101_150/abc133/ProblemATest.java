package abc.abc101_150.abc133;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4 2 9", "8");
	}

	@Test
	void case2() {
		check("4 2 7", "7");
	}

	@Test
	void case3() {
		check("4 2 8", "8");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC133/A");
	}
}

package abc.abc101_150.abc111;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("119", "991");
	}

	@Test
	void case2() {
		check("999", "111");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC111/A");
	}
}

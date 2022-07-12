package abc.abc101_150.abc144;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 5", "10");
	}

	@Test
	void case2() {
		check("5 10", "-1");
	}

	@Test
	void case3() {
		check("9 9", "81");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC144/A");
	}
}

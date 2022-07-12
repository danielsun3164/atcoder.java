package abc.abc101_150.abc125;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 5 7", "10");
	}

	@Test
	void case2() {
		check("3 2 9", "6");
	}

	@Test
	void case3() {
		check("20 20 19", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC125/A");
	}
}

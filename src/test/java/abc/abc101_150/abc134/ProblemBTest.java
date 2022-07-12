package abc.abc101_150.abc134;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6 2", "2");
	}

	@Test
	void case2() {
		check("14 3", "2");
	}

	@Test
	void case3() {
		check("20 4", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC134/B");
	}
}

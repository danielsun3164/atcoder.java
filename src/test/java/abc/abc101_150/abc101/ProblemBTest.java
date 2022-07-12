package abc.abc101_150.abc101;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("12", "Yes");
	}

	@Test
	void case2() {
		check("101", "No");
	}

	@Test
	void case3() {
		check("999999999", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC101/B");
	}
}

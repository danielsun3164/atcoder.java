package abc.abc101_150.abc120;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("8 12 2", "2");
	}

	@Test
	void case2() {
		check("100 50 4", "5");
	}

	@Test
	void case3() {
		check("1 1 1", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC120/B");
	}
}

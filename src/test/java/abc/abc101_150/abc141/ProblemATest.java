package abc.abc101_150.abc141;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("Sunny", "Cloudy");
	}

	@Test
	void case2() {
		check("Rainy", "Sunny");
	}

	@Test
	void case3() {
		check("Cloudy", "Rainy");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC141/A");
	}
}

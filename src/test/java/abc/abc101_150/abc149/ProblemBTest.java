package abc.abc101_150.abc149;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 3 3", "0 2");
	}

	@Test
	void case2() {
		check("500000000000 500000000000 1000000000000", "0 0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC149/B");
	}
}

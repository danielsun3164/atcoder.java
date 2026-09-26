package abc.abc201_250.abc242;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("aba", "aab");
	}

	@Test
	void case2() {
		check("zzzz", "zzzz");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc242/B");
	}
}

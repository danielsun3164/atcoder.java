package abc.abc101_150.abc127;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 2 2", "8");
	}

	@Test
	void case2() {
		check("4 5 4", "87210");
	}

	@Test
	void case3() {
		check("100 100 5000", "817260251");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC127/E");
	}
}

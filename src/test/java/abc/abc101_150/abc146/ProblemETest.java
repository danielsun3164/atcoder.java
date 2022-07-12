package abc.abc101_150.abc146;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("5 4\n" + "1 4 2 3 5", "4");
	}

	@Test
	void case2() {
		check("8 4\n" + "4 2 4 2 4 2 4 2", "7");
	}

	@Test
	void case3() {
		check("10 7\n" + "14 15 92 65 35 89 79 32 38 46", "8");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC146/E");
	}
}

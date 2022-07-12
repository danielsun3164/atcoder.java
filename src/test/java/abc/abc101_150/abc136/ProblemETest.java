package abc.abc101_150.abc136;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "8 20", "7");
	}

	@Test
	void case2() {
		check("2 10\n" + "3 5", "8");
	}

	@Test
	void case3() {
		check("4 5\n" + "10 1 2 22", "7");
	}

	@Test
	void case4() {
		check("8 7\n" + "1 7 5 6 8 2 6 5", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC136/E");
	}
}

package abc.abc101_150.abc146;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("10 7 100", "9");
	}

	@Test
	void case2() {
		check("2 1 100000000000", "1000000000");
	}

	@Test
	void case3() {
		check("1000000000 1000000000 100", "0");
	}

	@Test
	void case4() {
		check("1234 56789 314159265", "254309");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC146/C");
	}
}

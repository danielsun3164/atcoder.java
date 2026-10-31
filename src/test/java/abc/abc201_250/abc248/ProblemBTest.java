package abc.abc201_250.abc248;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1 4 2", "2");
	}

	@Test
	void case2() {
		check("7 7 10", "0");
	}

	@Test
	void case3() {
		check("31 415926 5", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc248/B");
	}
}

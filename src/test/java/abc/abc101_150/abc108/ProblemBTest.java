package abc.abc101_150.abc108;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("0 0 0 1", "-1 1 -1 0");
	}

	@Test
	void case2() {
		check("2 3 6 6", "3 10 -1 7");
	}

	@Test
	void case3() {
		check("31 -41 -59 26", "-126 -64 -36 -131");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC108/B");
	}
}

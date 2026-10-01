package abc.abc201_250.abc243;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 3 5 2\n" + "2 3 1 4", "1" + LF + "2");
	}

	@Test
	void case2() {
		check("3\n" + "1 2 3\n" + "4 5 6", "0" + LF + "0");
	}

	@Test
	void case3() {
		check("7\n" + "4 8 1 7 9 5 6\n" + "3 5 1 7 8 2 6", "3" + LF + "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc243/B");
	}
}

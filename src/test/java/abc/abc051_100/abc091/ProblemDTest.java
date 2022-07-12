package abc.abc051_100.abc091;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 2\n" + "3 4", "2");
	}

	@Test
	void case2() {
		check("6\n" + "4 6 0 0 3 3\n" + "0 5 6 5 0 3", "8");
	}

	@Test
	void case3() {
		check("5\n" + "1 2 3 4 5\n" + "1 2 3 4 5", "2");
	}

	@Test
	void case4() {
		check("1\n" + "0\n" + "0", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC092/D");
	}
}

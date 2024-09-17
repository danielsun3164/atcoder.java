package other.joi2006yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3 10\n" + "0\n" + "1 1\n" + "2 2 3", "9");
	}

	@Test
	void case2() {
		check("4 20\n" + "2 1 2\n" + "1 3\n" + "1 4", "3");
	}

	@Test
	void case3() {
		check("2 5\n" + "2 1 2\n" + "0\n" + "0", "0");
	}

	@Test
	void case4() {
		check("3 3\n" + "0\n" + "1 1\n" + "2 2 3", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2006yo/D");
	}
}

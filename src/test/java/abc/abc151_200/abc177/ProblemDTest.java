package abc.abc151_200.abc177;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "1 2\n" + "3 4\n" + "5 1", "3");
	}

	@Test
	void case2() {
		check("4 10\n" + "1 2\n" + "2 1\n" + "1 2\n" + "2 1\n" + "1 2\n" + "1 3\n" + "1 4\n" + "2 3\n" + "2 4\n"
				+ "3 4", "4");
	}

	@Test
	void case3() {
		check("10 4\n" + "3 1\n" + "4 1\n" + "5 9\n" + "2 6", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC177/D");
	}
}

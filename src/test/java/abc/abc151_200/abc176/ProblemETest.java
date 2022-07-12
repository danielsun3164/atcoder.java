package abc.abc151_200.abc176;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 3 3\n" + "2 2\n" + "1 1\n" + "1 3", "3");
	}

	@Test
	void case2() {
		check("3 3 4\n" + "3 3\n" + "3 1\n" + "1 1\n" + "1 2", "3");
	}

	@Test
	void case3() {
		check("5 5 10\n" + "2 5\n" + "4 3\n" + "2 3\n" + "5 5\n" + "2 2\n" + "5 4\n" + "5 3\n" + "5 1\n" + "3 5\n"
				+ "1 4", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC176/E");
	}
}

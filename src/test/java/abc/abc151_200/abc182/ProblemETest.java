package abc.abc151_200.abc182;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 3 2 1\n" + "1 1\n" + "2 3\n" + "2 2", "7");
	}

	@Test
	void case2() {
		check("4 4 3 3\n" + "1 2\n" + "1 3\n" + "3 4\n" + "2 3\n" + "2 4\n" + "3 2", "8");
	}

	@Test
	void case3() {
		check("5 5 5 1\n" + "1 1\n" + "2 2\n" + "3 3\n" + "4 4\n" + "5 5\n" + "4 2", "24");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC182/E");
	}
}

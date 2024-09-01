package abc.abc201_250.abc224;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("3 4\n" + "4 3 6\n" + "5 2 3 4\n" + "1 2 3 2\n" + "2 1 2 3\n" + "3 2 1 2", "37");
	}

	@Test
	void case2() {
		check("1 1\n" + "10\n" + "10\n" + "0", "0");
	}

	@Test
	void case3() {
		check("5 6\n" + "3 2 6 7 5\n" + "4 9 8 6 2 3\n" + "2 0 2 1 1 0\n" + "2 3 2 1 0 0\n" + "2 2 4 0 2 2\n"
				+ "4 1 0 3 0 2\n" + "1 0 0 2 2 5", "79");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc224/H");
	}
}

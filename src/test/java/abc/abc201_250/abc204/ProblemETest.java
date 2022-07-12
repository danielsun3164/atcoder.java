package abc.abc201_250.abc204;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2 1\n" + "1 2 2 3", "4");
	}

	@Test
	void case2() {
		check("2 3\n" + "1 2 2 3\n" + "1 2 2 1\n" + "1 1 1 1", "3");
	}

	@Test
	void case3() {
		check("4 2\n" + "1 2 3 4\n" + "3 4 5 6", "-1");
	}

	@Test
	void case4() {
		check("6 9\n" + "1 1 0 0\n" + "1 3 1 2\n" + "1 5 2 3\n" + "5 2 16 5\n" + "2 6 1 10\n" + "3 4 3 4\n"
				+ "3 5 3 10\n" + "5 6 1 100\n" + "4 2 0 110", "20");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc204/E");
	}
}

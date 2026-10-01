package abc.abc201_250.abc243;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 2 2\n" + "2 3 3\n" + "1 3 6", "1");
	}

	@Test
	void case2() {
		check("5 4\n" + "1 3 3\n" + "2 3 9\n" + "3 5 3\n" + "4 5 3", "0");
	}

	@Test
	void case3() {
		check("5 10\n" + "1 2 71\n" + "1 3 9\n" + "1 4 82\n" + "1 5 64\n" + "2 3 22\n" + "2 4 99\n" + "2 5 1\n"
				+ "3 4 24\n" + "3 5 18\n" + "4 5 10", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc243/E");
	}
}

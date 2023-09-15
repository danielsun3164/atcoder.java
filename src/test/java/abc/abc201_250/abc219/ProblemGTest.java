package abc.abc201_250.abc219;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("5 6 3\n" + "4 2\n" + "4 3\n" + "1 2\n" + "2 3\n" + "4 5\n" + "1 5\n" + "1 3 4", "1 3 3 3 3");
	}

	@Test
	void case2() {
		check("14 14 8\n" + "7 4\n" + "13 9\n" + "9 8\n" + "4 3\n" + "7 2\n" + "13 8\n" + "12 8\n" + "11 3\n" + "6 3\n"
				+ "7 14\n" + "6 5\n" + "1 4\n" + "10 13\n" + "5 2\n" + "2 6 12 9 1 10 5 4",
				"1 6 1 1 6 6 1 9 9 10 11 12 10 14");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc219/G");
	}
}

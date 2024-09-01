package abc.abc201_250.abc231;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("2 3 6\n" + "1 1 1\n" + "1 2 10\n" + "1 3 100\n" + "2 1 1000\n" + "2 2 10000\n" + "2 3 100000", "1110");
	}

	@Test
	void case2() {
		check("1 7 7\n" + "1 2 200000000\n" + "1 7 700000000\n" + "1 4 400000000\n" + "1 3 300000000\n"
				+ "1 6 600000000\n" + "1 5 500000000\n" + "1 1 100000000", "2800000000");
	}

	@Test
	void case3() {
		check("3 3 8\n" + "3 2 1\n" + "3 1 2\n" + "2 3 1\n" + "2 2 100\n" + "2 1 100\n" + "1 3 2\n" + "1 2 100\n"
				+ "1 1 100", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc231/H");
	}
}

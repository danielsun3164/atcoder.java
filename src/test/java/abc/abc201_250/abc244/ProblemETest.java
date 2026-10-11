package abc.abc201_250.abc244;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4 4 4 1 3 2\n" + "1 2\n" + "2 3\n" + "3 4\n" + "1 4", "4");
	}

	@Test
	void case2() {
		check("6 5 10 1 2 3\n" + "2 3\n" + "2 4\n" + "4 6\n" + "3 6\n" + "1 5", "0");
	}

	@Test
	void case3() {
		check("10 15 20 4 4 6\n" + "2 6\n" + "2 7\n" + "5 7\n" + "4 5\n" + "2 4\n" + "3 7\n" + "1 7\n" + "1 4\n"
				+ "2 9\n" + "5 10\n" + "1 3\n" + "7 8\n" + "7 9\n" + "1 6\n" + "1 2", "952504739");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc244/E");
	}
}

package abc.abc151_200.abc160;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("1 2 2 2 1\n" + "2 4\n" + "5 1\n" + "3", "12");
	}

	@Test
	void case2() {
		check("2 2 2 2 2\n" + "8 6\n" + "9 1\n" + "2 1", "25");
	}

	@Test
	void case3() {
		check("2 2 4 4 4\n" + "11 12 13 14\n" + "21 22 23 24\n" + "1 2 3 4", "74");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC160/E");
	}
}

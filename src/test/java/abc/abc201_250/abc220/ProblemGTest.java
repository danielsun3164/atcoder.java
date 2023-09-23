package abc.abc201_250.abc220;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "0 3 10\n" + "3 3 10\n" + "-1 0 10\n" + "2 0 10000\n" + "4 0 10", "40");
	}

	@Test
	void case2() {
		check("6\n" + "0 1 1\n" + "1 4 20\n" + "2 7 300\n" + "5 6 4000\n" + "4 3 50000\n" + "3 0 600000", "650021");
	}

	@Test
	void case3() {
		check("7\n" + "-3 0 1\n" + "-2 0 1\n" + "-1 0 1\n" + "0 0 1\n" + "1 0 1\n" + "2 0 1\n" + "3 0 1", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc220/G");
	}
}

package abc.abc201_250.abc217;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemHTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 0 3\n" + "3 1 0\n" + "4 0 6", "7");
	}

	@Test
	void case2() {
		check("3\n" + "1 0 1\n" + "6 1 1\n" + "8 0 -1", "0");
	}

	@Test
	void case3() {
		check("5\n" + "1 0 1000000000\n" + "2 1 -1000000000\n" + "3 0 1000000000\n" + "4 1 -1000000000\n"
				+ "5 0 1000000000", "4999999997");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc217/H");
	}
}

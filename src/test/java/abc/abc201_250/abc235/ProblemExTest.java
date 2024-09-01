package abc.abc201_250.abc235;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemExTest extends TestBase {

	@Test
	void case1() {
		check("3 2 1\n" + "1 2 1\n" + "2 3 2", "6");
	}

	@Test
	void case2() {
		check("5 0 2", "16");
	}

	@Test
	void case3() {
		check("6 8 2\n" + "1 2 1\n" + "2 3 2\n" + "3 4 3\n" + "4 5 1\n" + "5 6 2\n" + "6 1 3\n" + "1 2 10\n"
				+ "1 1 100", "40");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc235/Ex");
	}
}

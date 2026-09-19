package abc.abc201_250.abc241;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("4 2\n" + "2 1\n" + "2 3", "2 4");
	}

	@Test
	void case2() {
		check("3 3\n" + "1 2\n" + "2 3\n" + "3 1", "");
	}

	@Test
	void case3() {
		check("7 9\n" + "6 5\n" + "1 2\n" + "3 4\n" + "5 3\n" + "6 2\n" + "1 5\n" + "3 2\n" + "6 4\n" + "1 4",
				"1 3 6 7");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc241/G");
	}
}

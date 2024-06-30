package abc.abc201_250.abc225;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "1 4\n" + "2 4\n" + "3 4\n" + "4 5", "Yes");
	}

	@Test
	void case2() {
		check("4\n" + "2 4\n" + "1 4\n" + "2 3", "No");
	}

	@Test
	void case3() {
		check("10\n" + "9 10\n" + "3 10\n" + "4 10\n" + "8 10\n" + "1 10\n" + "2 10\n" + "7 10\n" + "6 10\n" + "5 10",
				"Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc225/B");
	}
}

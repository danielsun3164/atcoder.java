package abc.abc151_200.abc185;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10 2 20\n" + "9 11\n" + "13 17", "Yes");
	}

	@Test
	void case2() {
		check("10 2 20\n" + "9 11\n" + "13 16", "No");
	}

	@Test
	void case3() {
		check("15 3 30\n" + "5 8\n" + "15 17\n" + "24 27", "Yes");
	}

	@Test
	void case4() {
		check("20 1 30\n" + "20 29", "No");
	}

	@Test
	void case5() {
		check("20 1 30\n" + "1 10", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC185/B");
	}
}

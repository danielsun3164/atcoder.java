package abc.abc151_200.abc153;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("10 3\n" + "4 5 6", "Yes");
	}

	@Test
	void case2() {
		check("20 3\n" + "4 5 6", "No");
	}

	@Test
	void case3() {
		check("210 5\n" + "31 41 59 26 53", "Yes");
	}

	@Test
	void case4() {
		check("211 5\n" + "31 41 59 26 53", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC153/B");
	}
}

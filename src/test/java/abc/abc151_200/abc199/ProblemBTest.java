package abc.abc151_200.abc199;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "3 2\n" + "7 5", "3");
	}

	@Test
	void case2() {
		check("3\n" + "1 5 3\n" + "10 7 3", "0");
	}

	@Test
	void case3() {
		check("3\n" + "3 2 5\n" + "6 9 8", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc199/B");
	}
}

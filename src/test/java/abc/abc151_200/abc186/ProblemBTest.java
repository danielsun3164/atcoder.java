package abc.abc151_200.abc186;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2 3\n" + "2 2 3\n" + "3 2 2", "2");
	}

	@Test
	void case2() {
		check("3 3\n" + "99 99 99\n" + "99 0 99\n" + "99 99 99", "792");
	}

	@Test
	void case3() {
		check("3 2\n" + "4 4\n" + "4 4\n" + "4 4", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC186/B");
	}
}

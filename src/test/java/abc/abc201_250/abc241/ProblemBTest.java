package abc.abc201_250.abc241;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "1 1 3\n" + "3 1", "Yes");
	}

	@Test
	void case2() {
		check("1 1\n" + "1000000000\n" + "1", "No");
	}

	@Test
	void case3() {
		check("5 2\n" + "1 2 3 4 5\n" + "5 5", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc241/B");
	}
}

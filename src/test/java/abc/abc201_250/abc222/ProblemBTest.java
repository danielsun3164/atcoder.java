package abc.abc201_250.abc222;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 50\n" + "80 60 40 0", "2");
	}

	@Test
	void case2() {
		check("3 90\n" + "89 89 89", "3");
	}

	@Test
	void case3() {
		check("2 22\n" + "6 37", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc222/B");
	}
}

package abc.abc051_100.abc065;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "3\n" + "1\n" + "2", "2");
	}

	@Test
	void case2() {
		check("4\n" + "3\n" + "4\n" + "1\n" + "2", "-1");
	}

	@Test
	void case3() {
		check("5\n" + "3\n" + "3\n" + "4\n" + "2\n" + "4", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC076/B");
	}
}

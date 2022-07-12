package abc.abc051_100.abc087;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "2\n" + "2\n" + "100", "2");
	}

	@Test
	void case2() {
		check("5\n" + "1\n" + "0\n" + "150", "0");
	}

	@Test
	void case3() {
		check("30\n" + "40\n" + "50\n" + "6000", "213");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC090/B");
	}
}

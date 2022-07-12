package abc.abc051_100.abc074;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("1\n" + "10\n" + "2", "4");
	}

	@Test
	void case2() {
		check("2\n" + "9\n" + "3 6", "12");
	}

	@Test
	void case3() {
		check("5\n" + "20\n" + "11 12 9 17 12", "74");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC083/B");
	}
}

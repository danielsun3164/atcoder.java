package abc.abc051_100.abc092;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("600\n" + "300\n" + "220\n" + "420", "520");
	}

	@Test
	void case2() {
		check("555\n" + "555\n" + "400\n" + "200", "755");
	}

	@Test
	void case3() {
		check("549\n" + "817\n" + "715\n" + "603", "1152");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC093/A");
	}
}

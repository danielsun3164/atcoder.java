package abc.abc201_250.abc213;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "1 123 12345 12 1234 123456", "3");
	}

	@Test
	void case2() {
		check("5\n" + "3 1 4 15 9", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc213/B");
	}
}

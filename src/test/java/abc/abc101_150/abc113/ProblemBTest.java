package abc.abc101_150.abc113;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "12 5\n" + "1000 2000", "1");
	}

	@Test
	void case2() {
		check("3\n" + "21 -11\n" + "81234 94124 52141", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC113/B");
	}
}

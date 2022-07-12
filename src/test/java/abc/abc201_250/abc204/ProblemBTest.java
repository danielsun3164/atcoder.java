package abc.abc201_250.abc204;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "6 17 28", "25");
	}

	@Test
	void case2() {
		check("4\n" + "8 9 10 11", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc204/B");
	}
}

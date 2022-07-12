package abc.abc051_100.abc055;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3", "6");
	}

	@Test
	void case2() {
		check("10", "3628800");
	}

	@Test
	void case3() {
		check("100000", "457992974");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC069/B");
	}
}

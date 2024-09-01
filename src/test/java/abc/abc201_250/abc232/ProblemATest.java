package abc.abc201_250.abc232;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3x7", "21");
	}

	@Test
	void case2() {
		check("9x9", "81");
	}

	@Test
	void case3() {
		check("1x1", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc232/A");
	}
}

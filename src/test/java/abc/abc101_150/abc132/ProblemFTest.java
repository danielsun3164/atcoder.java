package abc.abc101_150.abc132;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 2", "5");
	}

	@Test
	void case2() {
		check("10 3", "147");
	}

	@Test
	void case3() {
		check("314159265 35", "457397712");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC132/F");
	}
}

package abc.abc101_150.abc127;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("30 100", "100");
	}

	@Test
	void case2() {
		check("12 100", "50");
	}

	@Test
	void case3() {
		check("0 100", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC127/A");
	}
}

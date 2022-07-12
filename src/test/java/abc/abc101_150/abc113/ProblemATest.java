package abc.abc101_150.abc113;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("81 58", "110");
	}

	@Test
	void case2() {
		check("4 54", "31");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC113/A");
	}
}

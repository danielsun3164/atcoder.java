package abc.abc051_100.abc081;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("101", "2");
	}

	@Test
	void case2() {
		check("000", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC086/A");
	}
}

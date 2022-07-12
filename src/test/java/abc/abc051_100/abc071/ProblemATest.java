package abc.abc051_100.abc071;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 2 7", "B");
	}

	@Test
	void case2() {
		check("1 999 1000", "A");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC081/A");
	}
}

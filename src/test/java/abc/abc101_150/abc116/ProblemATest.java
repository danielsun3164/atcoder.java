package abc.abc101_150.abc116;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 4 5", "6");
	}

	@Test
	void case2() {
		check("5 12 13", "30");
	}

	@Test
	void case3() {
		check("45 28 53", "630");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC116/A");
	}
}

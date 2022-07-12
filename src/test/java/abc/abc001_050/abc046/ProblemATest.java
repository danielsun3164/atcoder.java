package abc.abc001_050.abc046;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 1 4", "3");
	}

	@Test
	void case2() {
		check("3 3 33", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC062/A");
	}
}

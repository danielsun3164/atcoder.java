package abc.abc051_100.abc053;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1000", "ABC");
	}

	@Test
	void case2() {
		check("2000", "ARC");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC068/A");
	}
}

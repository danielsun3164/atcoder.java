package abc.abc051_100.abc069;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 4", "6");
	}

	@Test
	void case2() {
		check("2 2", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC080/A");
	}
}

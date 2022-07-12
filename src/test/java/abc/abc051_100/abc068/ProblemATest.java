package abc.abc051_100.abc068;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("100", "ABC100");
	}

	@Test
	void case2() {
		check("425", "ABC425");
	}

	@Test
	void case3() {
		check("999", "ABC999");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC079/A");
	}
}

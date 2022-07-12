package abc.abc051_100.abc068;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("7", "4");
	}

	@Test
	void case2() {
		check("32", "32");
	}

	@Test
	void case3() {
		check("1", "1");
	}

	@Test
	void case4() {
		check("100", "64");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC079/B");
	}
}

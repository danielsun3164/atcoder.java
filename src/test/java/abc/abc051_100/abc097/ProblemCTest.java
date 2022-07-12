package abc.abc051_100.abc097;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("aba\n" + "4", "b");
	}

	@Test
	void case2() {
		check("atcoderandatcodeer\n" + "5", "andat");
	}

	@Test
	void case3() {
		check("z\n" + "1", "z");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC097/C");
	}
}

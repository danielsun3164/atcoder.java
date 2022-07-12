package abc.abc051_100.abc055;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "ooxoox", "SSSWWS");
	}

	@Test
	void case2() {
		check("3\n" + "oox", "-1");
	}

	@Test
	void case3() {
		check("10\n" + "oxooxoxoox", "SSWWSSSWWS");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC069/D");
	}
}

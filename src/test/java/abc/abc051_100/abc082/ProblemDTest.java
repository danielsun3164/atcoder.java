package abc.abc051_100.abc082;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("FTFFTFFF\n" + "4 2", "Yes");
	}

	@Test
	void case2() {
		check("FTFFTFFF\n" + "-2 -2", "Yes");
	}

	@Test
	void case3() {
		check("FF\n" + "1 0", "No");
	}

	@Test
	void case4() {
		check("TF\n" + "1 0", "No");
	}

	@Test
	void case5() {
		check("FFTTFF\n" + "0 0", "Yes");
	}

	@Test
	void case6() {
		check("TTTT\n" + "1 0", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC087/D");
	}
}

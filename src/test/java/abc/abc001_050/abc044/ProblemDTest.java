package abc.abc001_050.abc044;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("87654\n" + "30", "10");
	}

	@Test
	void case2() {
		check("87654\n" + "138", "100");
	}

	@Test
	void case3() {
		check("87654\n" + "45678", "-1");
	}

	@Test
	void case4() {
		check("31415926535\n" + "1", "31415926535");
	}

	@Test
	void case5() {
		check("1\n" + "31415926535", "-1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC060/D");
	}
}

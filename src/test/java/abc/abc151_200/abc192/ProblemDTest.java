package abc.abc151_200.abc192;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("22\n" + "10", "2");
	}

	@Test
	void case2() {
		check("999\n" + "1500", "3");
	}

	@Test
	void case3() {
		check("100000000000000000000000000000000000000000000000000000000000\n" + "1000000000000000000", "1");
	}

	@Test
	void case4() {
		check("9\n" + "10", "1");
	}

	@Test
	void case5() {
		check("2\n" + "1", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC192/D");
	}
}

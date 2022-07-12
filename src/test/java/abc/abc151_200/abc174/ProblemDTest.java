package abc.abc151_200.abc174;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "WWRR", "2");
	}

	@Test
	void case2() {
		check("2\n" + "RR", "0");
	}

	@Test
	void case3() {
		check("8\n" + "WRWWRWRR", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC174/D");
	}
}

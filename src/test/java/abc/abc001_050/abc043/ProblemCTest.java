package abc.abc001_050.abc043;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "4 8", "8");
	}

	@Test
	void case2() {
		check("3\n" + "1 1 3", "3");
	}

	@Test
	void case3() {
		check("3\n" + "4 2 5", "5");
	}

	@Test
	void case4() {
		check("4\n" + "-100 -100 -100 -100", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC059_ABC043/C");
	}
}

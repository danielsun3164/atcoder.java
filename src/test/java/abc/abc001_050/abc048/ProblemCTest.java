package abc.abc001_050.abc048;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "2 2 2", "1");
	}

	@Test
	void case2() {
		check("6 1\n" + "1 6 1 2 0 4", "11");
	}

	@Test
	void case3() {
		check("5 9\n" + "3 1 4 1 5", "0");
	}

	@Test
	void case4() {
		check("2 0\n" + "5 5", "10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC064/C");
	}
}

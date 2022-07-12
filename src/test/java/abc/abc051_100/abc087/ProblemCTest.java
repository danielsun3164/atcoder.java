package abc.abc051_100.abc087;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "3 2 2 4 1\n" + "1 2 2 2 1", "14");
	}

	@Test
	void case2() {
		check("4\n" + "1 1 1 1\n" + "1 1 1 1", "5");
	}

	@Test
	void case3() {
		check("7\n" + "3 3 4 5 4 5 3\n" + "5 3 4 4 2 3 2", "29");
	}

	@Test
	void case4() {
		check("1\n" + "2\n" + "3", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC090/C");
	}
}

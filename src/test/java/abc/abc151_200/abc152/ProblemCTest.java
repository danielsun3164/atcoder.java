package abc.abc151_200.abc152;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "4 2 5 1 3", "3");
	}

	@Test
	void case2() {
		check("4\n" + "4 3 2 1", "4");
	}

	@Test
	void case3() {
		check("6\n" + "1 2 3 4 5 6", "1");
	}

	@Test
	void case4() {
		check("8\n" + "5 7 4 2 6 8 1 3", "4");
	}

	@Test
	void case5() {
		check("1\n" + "1", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC152/C");
	}
}

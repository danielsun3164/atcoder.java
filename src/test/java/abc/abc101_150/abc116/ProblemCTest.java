package abc.abc101_150.abc116;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "1 2 2 1", "2");
	}

	@Test
	void case2() {
		check("5\n" + "3 1 2 3 1", "5");
	}

	@Test
	void case3() {
		check("8\n" + "4 23 75 0 23 96 50 100", "221");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC116/C");
	}
}

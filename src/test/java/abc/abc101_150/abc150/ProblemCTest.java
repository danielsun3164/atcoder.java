package abc.abc101_150.abc150;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 3 2\n" + "3 1 2", "3");
	}

	@Test
	void case2() {
		check("8\n" + "7 3 5 4 2 1 6 8\n" + "3 8 2 5 4 6 7 1", "17517");
	}

	@Test
	void case3() {
		check("3\n" + "1 2 3\n" + "1 2 3", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC150/C");
	}
}

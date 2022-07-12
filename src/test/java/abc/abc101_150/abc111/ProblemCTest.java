package abc.abc101_150.abc111;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "3 1 3 2", "1");
	}

	@Test
	void case2() {
		check("6\n" + "105 119 105 119 105 119", "0");
	}

	@Test
	void case3() {
		check("4\n" + "1 1 1 1", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC111/C");
	}
}

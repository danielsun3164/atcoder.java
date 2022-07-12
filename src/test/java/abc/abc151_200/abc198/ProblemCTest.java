package abc.abc151_200.abc198;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 15 0", "3");
	}

	@Test
	void case2() {
		check("5 11 0", "3");
	}

	@Test
	void case3() {
		check("3 4 4", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc198/C");
	}
}

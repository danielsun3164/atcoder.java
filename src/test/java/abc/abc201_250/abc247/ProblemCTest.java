package abc.abc201_250.abc247;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2", "1 2 1");
	}

	@Test
	void case2() {
		check("1", "1");
	}

	@Test
	void case3() {
		check("4", "1 2 1 3 1 2 1 4 1 2 1 3 1 2 1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc247/C");
	}
}

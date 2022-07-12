package abc.abc151_200.abc196;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 2 1 2", "4");
	}

	@Test
	void case2() {
		check("3 3 4 1", "18");
	}

	@Test
	void case3() {
		check("4 4 8 0", "36");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC196/D");
	}
}

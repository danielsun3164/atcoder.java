package abc.abc151_200.abc179;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 2\n" + "1 1\n" + "3 4", "4");
	}

	@Test
	void case2() {
		check("5 2\n" + "3 3\n" + "5 5", "0");
	}

	@Test
	void case3() {
		check("5 1\n" + "1 2", "5");
	}

	@Test
	void case4() {
		check("60 3\n" + "5 8\n" + "1 3\n" + "10 15", "221823067");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC179/D");
	}
}

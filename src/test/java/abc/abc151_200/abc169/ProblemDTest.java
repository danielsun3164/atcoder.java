package abc.abc151_200.abc169;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("24", "3");
	}

	@Test
	void case2() {
		check("1", "0");
	}

	@Test
	void case3() {
		check("64", "3");
	}

	@Test
	void case4() {
		check("1000000007", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC169/D");
	}
}

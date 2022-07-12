package abc.abc151_200.abc172;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4", "23");
	}

	@Test
	void case2() {
		check("100", "26879");
	}

	@Test
	void case3() {
		check("10000000", "838627288460105");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC172/D");
	}
}

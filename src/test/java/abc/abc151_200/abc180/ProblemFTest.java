package abc.abc151_200.abc180;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3 2 3", "3");
	}

	@Test
	void case2() {
		check("4 3 2", "6");
	}

	@Test
	void case3() {
		check("300 290 140", "211917445");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC180/F");
	}
}

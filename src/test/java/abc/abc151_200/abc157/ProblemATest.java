package abc.abc151_200.abc157;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5", "3");
	}

	@Test
	void case2() {
		check("2", "1");
	}

	@Test
	void case3() {
		check("100", "50");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC157/A");
	}
}

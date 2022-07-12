package abc.abc151_200.abc185;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 3 7 11", "3");
	}

	@Test
	void case2() {
		check("100 100 1 100", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC185/A");
	}
}

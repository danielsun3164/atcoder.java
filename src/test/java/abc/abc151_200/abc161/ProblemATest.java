package abc.abc151_200.abc161;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 2 3", "3 1 2");
	}

	@Test
	void case2() {
		check("100 100 100", "100 100 100");
	}

	@Test
	void case3() {
		check("41 59 31", "31 41 59");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC161/A");
	}
}

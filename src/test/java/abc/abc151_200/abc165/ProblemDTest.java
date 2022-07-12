package abc.abc151_200.abc165;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5 7 4", "2");
	}

	@Test
	void case2() {
		check("11 10 9", "9");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC165/D");
	}
}

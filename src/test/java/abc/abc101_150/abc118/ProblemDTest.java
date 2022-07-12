package abc.abc101_150.abc118;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("20 4\n" + "3 7 8 4", "777773");
	}

	@Test
	void case2() {
		check("101 9\n" + "9 8 7 6 5 4 3 2 1", "71111111111111111111111111111111111111111111111111");
	}

	@Test
	void case3() {
		check("15 3\n" + "5 4 6", "654");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC118/D");
	}
}

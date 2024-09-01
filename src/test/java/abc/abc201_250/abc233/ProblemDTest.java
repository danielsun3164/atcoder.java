package abc.abc201_250.abc233;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("6 5\n" + "8 -3 5 7 0 -4", "3");
	}

	@Test
	void case2() {
		check("2 -1000000000000000\n" + "1000000000 -1000000000", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc233/D");
	}
}

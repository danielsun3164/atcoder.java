package abc.abc201_250.abc219;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("56", "14");
	}

	@Test
	void case2() {
		check("32", "8");
	}

	@Test
	void case3() {
		check("0", "40");
	}

	@Test
	void case4() {
		check("100", "expert");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc219/A");
	}
}

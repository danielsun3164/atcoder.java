package abc.abc101_150.abc142;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("12 18", "3");
	}

	@Test
	void case2() {
		check("420 660", "4");
	}

	@Test
	void case3() {
		check("1 2019", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC142/D");
	}
}

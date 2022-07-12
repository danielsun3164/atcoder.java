package abc.abc101_150.abc103;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 6 3", "5");
	}

	@Test
	void case2() {
		check("11 5 5", "6");
	}

	@Test
	void case3() {
		check("100 100 100", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC103/A");
	}
}

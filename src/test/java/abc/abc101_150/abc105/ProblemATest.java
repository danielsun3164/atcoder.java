package abc.abc101_150.abc105;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("7 3", "1");
	}

	@Test
	void case2() {
		check("100 10", "0");
	}

	@Test
	void case3() {
		check("1 1", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC105/A");
	}
}

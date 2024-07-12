package abc.abc201_250.abc227;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 3 2", "1");
	}

	@Test
	void case2() {
		check("1 100 1", "1");
	}

	@Test
	void case3() {
		check("3 14 2", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc227/A");
	}
}

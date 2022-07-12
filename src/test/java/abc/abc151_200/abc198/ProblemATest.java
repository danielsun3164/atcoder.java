package abc.abc151_200.abc198;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2", "1");
	}

	@Test
	void case2() {
		check("1", "0");
	}

	@Test
	void case3() {
		check("3", "2");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc198/A");
	}
}

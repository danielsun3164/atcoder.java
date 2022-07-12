package abc.abc151_200.abc177;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1000 15 80", "Yes");
	}

	@Test
	void case2() {
		check("2000 20 100", "Yes");
	}

	@Test
	void case3() {
		check("10000 1 1", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC177/A");
	}
}

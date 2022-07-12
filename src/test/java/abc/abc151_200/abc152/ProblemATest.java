package abc.abc151_200.abc152;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 3", "Yes");
	}

	@Test
	void case2() {
		check("3 2", "No");
	}

	@Test
	void case3() {
		check("1 1", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC152/A");
	}
}

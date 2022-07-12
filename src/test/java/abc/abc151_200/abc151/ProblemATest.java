package abc.abc151_200.abc151;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("a", "b");
	}

	@Test
	void case2() {
		check("y", "z");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC151/A");
	}
}

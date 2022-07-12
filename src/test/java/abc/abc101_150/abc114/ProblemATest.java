package abc.abc101_150.abc114;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5", "YES");
	}

	@Test
	void case2() {
		check("6", "NO");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC114/A");
	}
}

package abc.abc151_200.abc195;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("10 120", "Yes");
	}

	@Test
	void case2() {
		check("10 125", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC195/A");
	}
}

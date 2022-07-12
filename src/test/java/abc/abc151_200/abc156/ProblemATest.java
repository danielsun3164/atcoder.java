package abc.abc151_200.abc156;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 2919", "3719");
	}

	@Test
	void case2() {
		check("22 3051", "3051");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC156/A");
	}
}

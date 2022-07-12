package abc.abc201_250.abc213;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3 6", "5");
	}

	@Test
	void case2() {
		check("10 12", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc213/A");
	}
}

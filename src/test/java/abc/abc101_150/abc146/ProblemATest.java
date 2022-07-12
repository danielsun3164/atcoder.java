package abc.abc101_150.abc146;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("SAT", "1");
	}

	@Test
	void case2() {
		check("SUN", "7");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC146/A");
	}
}

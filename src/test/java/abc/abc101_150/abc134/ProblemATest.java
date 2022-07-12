package abc.abc101_150.abc134;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("4", "48");
	}

	@Test
	void case2() {
		check("15", "675");
	}

	@Test
	void case3() {
		check("80", "19200");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC134/A");
	}
}

package abc.abc101_150.abc134;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 0 0", "1" + LF + "1");
	}

	@Test
	void case2() {
		check("5\n" + "0 0 0 0 0", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC134/D");
	}
}

package abc.abc101_150.abc148;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1", "2");
	}

	@Test
	void case2() {
		check("1\n" + "2", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC148/A");
	}
}

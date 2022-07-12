package abc.abc101_150.abc140;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2", "8");
	}

	@Test
	void case2() {
		check("1", "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC140/A");
	}
}

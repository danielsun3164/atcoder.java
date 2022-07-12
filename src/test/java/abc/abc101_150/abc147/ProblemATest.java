package abc.abc101_150.abc147;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("5 7 9", "win");
	}

	@Test
	void case2() {
		check("13 7 2", "bust");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC147/A");
	}
}

package abc.abc101_150.abc129;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("1 3 4", "4");
	}

	@Test
	void case2() {
		check("3 2 3", "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC129/A");
	}
}

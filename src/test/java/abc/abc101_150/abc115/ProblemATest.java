package abc.abc101_150.abc115;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("25", "Christmas");
	}

	@Test
	void case2() {
		check("22", "Christmas Eve Eve Eve");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC115/A");
	}
}

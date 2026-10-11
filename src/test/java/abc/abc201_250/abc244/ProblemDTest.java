package abc.abc201_250.abc244;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("R G B\n" + "R G B", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc244/D");
	}
}

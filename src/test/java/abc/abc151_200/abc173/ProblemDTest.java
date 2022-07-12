package abc.abc151_200.abc173;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "2 2 1 3", "7");
	}

	@Test
	void case2() {
		check("7\n" + "1 1 1 1 1 1 1", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC173/D");
	}
}

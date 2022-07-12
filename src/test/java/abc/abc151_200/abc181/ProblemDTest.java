package abc.abc151_200.abc181;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("1234", "Yes");
	}

	@Test
	void case2() {
		check("1333", "No");
	}

	@Test
	void case3() {
		check("8", "Yes");
	}

	@Test
	void case4() {
		check("4", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC181/D");
	}
}

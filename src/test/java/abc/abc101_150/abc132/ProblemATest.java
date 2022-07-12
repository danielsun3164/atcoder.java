package abc.abc101_150.abc132;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("ASSA", "Yes");
	}

	@Test
	void case2() {
		check("STOP", "No");
	}

	@Test
	void case3() {
		check("FFEE", "Yes");
	}

	@Test
	void case4() {
		check("FREE", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC132/A");
	}
}

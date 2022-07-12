package abc.abc101_150.abc136;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("6 4 3", "1");
	}

	@Test
	void case2() {
		check("8 3 9", "4");
	}

	@Test
	void case3() {
		check("12 3 7", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC136/A");
	}
}

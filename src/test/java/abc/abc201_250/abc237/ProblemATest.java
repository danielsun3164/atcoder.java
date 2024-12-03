package abc.abc201_250.abc237;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("10", "Yes");
	}

	@Test
	void case2() {
		check("-9876543210", "No");
	}

	@Test
	void case3() {
		check("483597848400000", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc237/A");
	}
}

package abc.abc201_250.abc228;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("7 20 12", "Yes");
	}

	@Test
	void case2() {
		check("20 7 12", "No");
	}

	@Test
	void case3() {
		check("23 0 23", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc228/A");
	}
}

package abc.abc051_100.abc089;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("8", "2");
	}

	@Test
	void case2() {
		check("2", "0");
	}

	@Test
	void case3() {
		check("9", "3");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC089/A");
	}
}

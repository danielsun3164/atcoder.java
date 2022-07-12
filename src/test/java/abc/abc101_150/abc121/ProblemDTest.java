package abc.abc101_150.abc121;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 4", "5");
	}

	@Test
	void case2() {
		check("123 456", "435");
	}

	@Test
	void case3() {
		check("123456789012 123456789012", "123456789012");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC121/D");
	}
}

package abc.abc201_250.abc212;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("7777", "Weak");
	}

	@Test
	void case2() {
		check("0112", "Strong");
	}

	@Test
	void case3() {
		check("9012", "Weak");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc212/B");
	}
}

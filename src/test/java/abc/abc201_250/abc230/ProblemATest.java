package abc.abc201_250.abc230;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("42", "AGC043");
	}

	@Test
	void case2() {
		check("19", "AGC019");
	}

	@Test
	void case3() {
		check("1", "AGC001");
	}

	@Test
	void case4() {
		check("50", "AGC051");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc230/A");
	}
}

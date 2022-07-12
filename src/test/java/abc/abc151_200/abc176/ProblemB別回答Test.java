package abc.abc151_200.abc176;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemB別回答Test extends TestBase {

	@Test
	void case1() {
		check("123456789", "Yes");
	}

	@Test
	void case2() {
		check("0", "Yes");
	}

	@Test
	void case3() {
		check("31415926535897932384626433832795028841971693993751058209749445923078164062862089986280", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC176/B");
	}
}

package abc.abc151_200.abc154;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("sardine", "xxxxxxx");
	}

	@Test
	void case2() {
		check("xxxx", "xxxx");
	}

	@Test
	void case3() {
		check("gone", "xxxx");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC154/B");
	}
}

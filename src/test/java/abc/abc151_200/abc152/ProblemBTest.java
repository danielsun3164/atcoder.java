package abc.abc151_200.abc152;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("4 3", "3333");
	}

	@Test
	void case2() {
		check("7 7", "7777777");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC152/B");
	}
}

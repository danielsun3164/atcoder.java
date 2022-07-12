package abc.abc051_100.abc054;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 2\n" + "#.#\n" + ".#.\n" + "#.#\n" + "#.\n" + ".#", "Yes");
	}

	@Test
	void case2() {
		check("4 1\n" + "....\n" + "....\n" + "....\n" + "....\n" + "#", "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC054/B");
	}
}

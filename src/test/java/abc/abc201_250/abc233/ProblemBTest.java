package abc.abc201_250.abc233;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("3 7\n" + "abcdefgh", "abgfedch");
	}

	@Test
	void case2() {
		check("1 7\n" + "reviver", "reviver");
	}

	@Test
	void case3() {
		check("4 13\n" + "merrychristmas", "meramtsirhcyrs");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc233/B");
	}
}

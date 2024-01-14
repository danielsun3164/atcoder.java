package abc.abc201_250.abc221;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("abc\n" + "acb", "Yes");
	}

	@Test
	void case2() {
		check("aabb\n" + "bbaa", "No");
	}

	@Test
	void case3() {
		check("abcde\n" + "abcde", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc221/B");
	}
}

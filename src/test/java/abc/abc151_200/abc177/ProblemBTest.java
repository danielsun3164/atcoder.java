package abc.abc151_200.abc177;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("cabacc\n" + "abc", "1");
	}

	@Test
	void case2() {
		check("codeforces\n" + "atcoder", "6");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC177/B");
	}
}

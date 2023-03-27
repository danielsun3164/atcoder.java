package abc.abc201_250.abc217;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("abc atcoder", "Yes");
	}

	@Test
	void case2() {
		check("arc agc", "No");
	}

	@Test
	void case3() {
		check("a aa", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc217/A");
	}
}

package abc.abc201_250.abc224;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("atcoder", "er");
	}

	@Test
	void case2() {
		check("tourist", "ist");
	}

	@Test
	void case3() {
		check("er", "er");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc224/A");
	}
}

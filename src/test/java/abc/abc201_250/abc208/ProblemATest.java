package abc.abc201_250.abc208;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("2 11", "Yes");
	}

	@Test
	void case2() {
		check("2 13", "No");
	}

	@Test
	void case3() {
		check("100 600", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc208/A");
	}
}

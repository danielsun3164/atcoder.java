package abc.abc151_200.abc197;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("abc", "bca");
	}

	@Test
	void case2() {
		check("aab", "aba");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC197/A");
	}
}

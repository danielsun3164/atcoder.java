package abc.abc201_250.abc234;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("aab", "8");
	}

	@Test
	void case2() {
		check("aaa", "3");
	}

	@Test
	void case3() {
		check("abcdefghijklmnopqrstuvwxyz", "149621752");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc234/F");
	}
}

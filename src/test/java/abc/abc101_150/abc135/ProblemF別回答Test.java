package abc.abc101_150.abc135;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("abcabab\n" + "ab", "3");
	}

	@Test
	void case2() {
		check("aa\n" + "aaaaaaa", "-1");
	}

	@Test
	void case3() {
		check("aba\n" + "baaab", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC135/F");
	}
}

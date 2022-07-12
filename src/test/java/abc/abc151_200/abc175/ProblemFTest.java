package abc.abc151_200.abc175;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("3\n" + "ba 3\n" + "abc 4\n" + "cbaa 5", "7");
	}

	@Test
	void case2() {
		check("2\n" + "abcab 5\n" + "cba 3", "11");
	}

	@Test
	void case3() {
		check("2\n" + "abc 1\n" + "ab 2", "-1");
	}

	@Test
	void case4() {
		check("3\n" + "ba 3\n" + "abc 4\n" + "cbaa 5", "7");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC175/F");
	}
}

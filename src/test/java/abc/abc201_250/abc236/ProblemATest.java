package abc.abc201_250.abc236;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("chokudai\n" + "3 5", "chukodai");
	}

	@Test
	void case2() {
		check("aa\n" + "1 2", "aa");
	}

	@Test
	void case3() {
		check("aaaabbbb\n" + "1 8", "baaabbba");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc236/A");
	}
}

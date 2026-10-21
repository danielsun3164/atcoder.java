package abc.abc201_250.abc246;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答Test extends TestBase {

	@Test
	void case1() {
		check("2 2\n" + "ab\n" + "ac", "7");
	}

	@Test
	void case2() {
		check("4 3\n" + "abcdefg\n" + "hijklmnop\n" + "qrstuv\n" + "wxyz", "1352");
	}

	@Test
	void case3() {
		check("5 1000000000\n" + "abc\n" + "acde\n" + "cefg\n" + "abcfh\n" + "dghi", "346462871");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc246/F");
	}
}

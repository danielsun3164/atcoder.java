package abc.abc201_250.abc219;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("bacdefghijklmnopqrstuvwxzy\n" + "4\n" + "abx\n" + "bzz\n" + "bzy\n" + "caa",
				"bzz\n" + "bzy\n" + "abx\n" + "caa");
	}

	@Test
	void case2() {
		check("zyxwvutsrqponmlkjihgfedcba\n" + "5\n" + "a\n" + "ab\n" + "abc\n" + "ac\n" + "b",
				"b\n" + "a\n" + "ac\n" + "ab\n" + "abc");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc219/C");
	}
}

package abc.abc101_150.abc146;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "ABCXYZ", "CDEZAB");
	}

	@Test
	void case2() {
		check("0\n" + "ABCXYZ", "ABCXYZ");
	}

	@Test
	void case3() {
		check("13\n" + "ABCDEFGHIJKLMNOPQRSTUVWXYZ", "NOPQRSTUVWXYZABCDEFGHIJKLM");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC146/B");
	}
}

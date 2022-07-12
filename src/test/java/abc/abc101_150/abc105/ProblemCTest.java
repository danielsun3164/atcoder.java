package abc.abc101_150.abc105;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("-9", "1011");
	}

	@Test
	void case2() {
		check("123456789", "11000101011001101110100010101");
	}

	@Test
	void case3() {
		check("0", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC105/C");
	}
}

package abc.abc101_150.abc109;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("3 3\n" + "1 7 11", "2");
	}

	@Test
	void case2() {
		check("3 81\n" + "33 105 57", "24");
	}

	@Test
	void case3() {
		check("1 1\n" + "1000000000", "999999999");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC109/C");
	}
}

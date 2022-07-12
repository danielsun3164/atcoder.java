package abc.abc101_150.abc129;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6 1\n" + "3", "4");
	}

	@Test
	void case2() {
		check("10 2\n" + "4\n" + "5", "0");
	}

	@Test
	void case3() {
		check("100 5\n" + "1\n" + "23\n" + "45\n" + "67\n" + "89", "608200469");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC129/C");
	}
}

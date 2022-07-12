package abc.abc101_150.abc124;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("000", "1");
	}

	@Test
	void case2() {
		check("10010010", "3");
	}

	@Test
	void case3() {
		check("0", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC124/C");
	}
}

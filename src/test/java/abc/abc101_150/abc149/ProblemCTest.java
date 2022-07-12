package abc.abc101_150.abc149;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("20", "23");
	}

	@Test
	void case2() {
		check("2", "2");
	}

	@Test
	void case3() {
		check("99992", "100003");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC149/C");
	}
}

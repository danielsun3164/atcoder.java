package abc.abc101_150.abc133;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2020 2040", "2");
	}

	@Test
	void case2() {
		check("4 5", "20");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC133/C");
	}
}

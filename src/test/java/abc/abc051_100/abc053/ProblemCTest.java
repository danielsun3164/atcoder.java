package abc.abc051_100.abc053;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("7", "2");
	}

	@Test
	void case2() {
		check("149696127901", "27217477801");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC068/C");
	}
}

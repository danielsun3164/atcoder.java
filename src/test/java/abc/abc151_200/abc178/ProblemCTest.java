package abc.abc151_200.abc178;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2", "2");
	}

	@Test
	void case2() {
		check("1", "0");
	}

	@Test
	void case3() {
		check("869121", "2511445");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC178/C");
	}
}

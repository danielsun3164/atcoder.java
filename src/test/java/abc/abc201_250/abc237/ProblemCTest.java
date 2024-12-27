package abc.abc201_250.abc237;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("kasaka", "Yes");
	}

	@Test
	void case2() {
		check("atcoder", "No");
	}

	@Test
	void case3() {
		check("php", "Yes");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc237/C");
	}
}

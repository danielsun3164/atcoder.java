package abc.abc201_250.abc212;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemGTest extends TestBase {

	@Test
	void case1() {
		check("3", "4");
	}

	@Test
	void case2() {
		check("11", "64");
	}

	@Test
	void case3() {
		check("998244353", "329133417");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc212/G");
	}
}

package abc.abc201_250.abc202;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("0601889", "6881090");
	}

	@Test
	void case2() {
		check("86910", "01698");
	}

	@Test
	void case3() {
		check("01010", "01010");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc202/B");
	}
}

package abc.abc201_250.abc211;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("chchokudai", "3");
	}

	@Test
	void case2() {
		check("atcoderrr", "0");
	}

	@Test
	void case3() {
		check("chokudaichokudaichokudai", "45");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc211/C");
	}
}

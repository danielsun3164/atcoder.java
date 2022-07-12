package other.zone2021;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("ozRnonnoe", "zone");
	}

	@Test
	void case2() {
		check("hellospaceRhellospace", "");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ZONe2021/D");
	}
}

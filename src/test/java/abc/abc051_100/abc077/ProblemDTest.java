package abc.abc051_100.abc077;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("6", "3");
	}

	@Test
	void case2() {
		check("41", "5");
	}

	@Test
	void case3() {
		check("79992", "36");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC084/D");
	}
}

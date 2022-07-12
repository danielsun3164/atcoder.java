package abc.abc201_250.abc206;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("180", "Yay!");
	}

	@Test
	void case2() {
		check("200", ":(");
	}

	@Test
	void case3() {
		check("191", "so-so");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc206/A");
	}
}

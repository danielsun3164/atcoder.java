package abc.abc201_250.abc239;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("2 3 3 4", "Aoki");
	}

	@Test
	void case2() {
		check("1 100 50 60", "Takahashi");
	}

	@Test
	void case3() {
		check("3 14 1 5", "Aoki");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc239/D");
	}
}

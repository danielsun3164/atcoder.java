package abc.abc201_250.abc245;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemATest extends TestBase {

	@Test
	void case1() {
		check("7 0 6 30", "Aoki");
	}

	@Test
	void case2() {
		check("7 30 7 30", "Takahashi");
	}

	@Test
	void case3() {
		check("0 0 23 59", "Takahashi");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc245/A");
	}
}

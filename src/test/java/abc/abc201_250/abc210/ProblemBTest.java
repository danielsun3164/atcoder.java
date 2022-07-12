package abc.abc201_250.abc210;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemBTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "00101", "Takahashi");
	}

	@Test
	void case2() {
		check("3\n" + "010", "Aoki");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc210/B");
	}
}

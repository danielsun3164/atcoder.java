package abc.abc151_200.abc162;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "RRGB", "1");
	}

	@Test
	void case2() {
		check("39\n" + "RBRBGRBGGBBRRGBBRRRBGGBRBGBRBGBRBBBGBBB", "1800");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC162/D");
	}
}

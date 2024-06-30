package abc.abc201_250.abc225;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemFTest extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "ode\n" + "zaaa\n" + "r\n" + "atc", "atcoder");
	}

	@Test
	void case2() {
		check("5 2\n" + "z\n" + "z\n" + "zzz\n" + "z\n" + "zzzzzz", "zz");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc225/F");
	}
}

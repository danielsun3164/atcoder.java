package abc.abc201_250.abc230;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemF別回答2Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "1 -1 1", "4");
	}

	@Test
	void case2() {
		check("10\n"
				+ "377914575 -275478149 0 -444175904 719654053 -254224494 -123690081 377914575 -254224494 -21253655",
				"321");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc230/F");
	}
}

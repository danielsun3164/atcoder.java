package abc.abc151_200.abc160;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("20 3\n" + "5 10 15", "10");
	}

	@Test
	void case2() {
		check("20 3\n" + "0 5 15", "10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC160/C");
	}
}

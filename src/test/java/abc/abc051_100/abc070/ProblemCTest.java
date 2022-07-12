package abc.abc051_100.abc070;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "2\n" + "3", "6");
	}

	@Test
	void case2() {
		check("5\n" + "2\n" + "5\n" + "10\n" + "1000000000000000000\n" + "1000000000000000000", "1000000000000000000");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC070/C");
	}
}

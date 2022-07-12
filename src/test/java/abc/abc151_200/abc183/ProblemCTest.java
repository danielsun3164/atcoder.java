package abc.abc151_200.abc183;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("4 330\n" + "0 1 10 100\n" + "1 0 20 200\n" + "10 20 0 300\n" + "100 200 300 0", "2");
	}

	@Test
	void case2() {
		check("5 5\n" + "0 1 1 1 1\n" + "1 0 1 1 1\n" + "1 1 0 1 1\n" + "1 1 1 0 1\n" + "1 1 1 1 0", "24");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC183/C");
	}
}

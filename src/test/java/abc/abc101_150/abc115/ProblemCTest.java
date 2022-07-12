package abc.abc101_150.abc115;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5 3\n" + "10\n" + "15\n" + "11\n" + "14\n" + "12", "2");
	}

	@Test
	void case2() {
		check("5 3\n" + "5\n" + "7\n" + "5\n" + "7\n" + "7", "0");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC115/C");
	}
}

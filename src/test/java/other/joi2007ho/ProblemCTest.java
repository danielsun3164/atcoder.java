package other.joi2007ho;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("10\n" + "9 4\n" + "4 3\n" + "1 1\n" + "4 2\n" + "2 4\n" + "5 8\n" + "4 0\n" + "5 3\n" + "0 5\n" + "5 2",
				"10");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2007ho/C");
	}
}

package other.joi2006ho;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("5", "5" + LF + "4 1" + LF + "3 2" + LF + "3 1 1" + LF + "2 2 1" + LF + "2 1 1 1" + LF + "1 1 1 1 1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2006ho/C");
	}
}

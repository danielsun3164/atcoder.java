package abc.abc001_050.abc045;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("125", "176");
	}

	@Test
	void case2() {
		check("9999999999", "12656242944");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ARC061/C");
	}
}

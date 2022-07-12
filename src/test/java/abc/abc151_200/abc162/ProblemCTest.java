package abc.abc151_200.abc162;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("2", "9");
	}

	@Test
	void case2() {
		check("200", "10813692");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC162/C");
	}
}

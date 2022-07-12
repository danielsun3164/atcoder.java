package abc.abc151_200.abc189;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("6\n" + "2 4 4 9 4 9", "20");
	}

	@Test
	void case2() {
		check("6\n" + "200 4 4 9 4 9", "200");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC189/C");
	}
}

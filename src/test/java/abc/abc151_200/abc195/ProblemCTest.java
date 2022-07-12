package abc.abc151_200.abc195;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("1010", "11");
	}

	@Test
	void case2() {
		check("27182818284590", "107730272137364");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC195/C");
	}
}

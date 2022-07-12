package abc.abc151_200.abc193;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemCTest extends TestBase {

	@Test
	void case1() {
		check("8", "6");
	}

	@Test
	void case2() {
		check("100000", "99634");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC193/C");
	}
}

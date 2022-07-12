package abc.abc151_200.abc195;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("2\n" + "35\n" + "AT", "Takahashi");
	}

	@Test
	void case2() {
		check("5\n" + "12345\n" + "AAAAT", "Aoki");
	}

	@Test
	void case3() {
		check("5\n" + "67890\n" + "TTTTA", "Takahashi");
	}

	@Test
	void case4() {
		check("5\n" + "12345\n" + "ATATA", "Aoki");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC195/E");
	}
}

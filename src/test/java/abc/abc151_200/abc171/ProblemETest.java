package abc.abc151_200.abc171;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemETest extends TestBase {

	@Test
	void case1() {
		check("4\n" + "20 11 9 24", "26 5 7 22");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC171/E");
	}
}

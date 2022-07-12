package abc.abc151_200.abc193;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答Test extends TestBase {

	@Test
	void case1() {
		check("3\n" + "5 2 7 6\n" + "1 1 3 1\n" + "999999999 1 1000000000 1",
				"20" + LF + "infinity" + LF + "1000000000999999999");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC193/E");
	}
}

package abc.abc151_200.abc157;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemE別回答Test extends TestBase {

	@Test
	void case1() {
		check("7\n" + "abcdbbd\n" + "6\n" + "2 3 6\n" + "1 5 z\n" + "2 1 1\n" + "1 4 a\n" + "1 7 d\n" + "2 1 7",
				"3" + LF + "1" + LF + "5");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("ABC157/E");
	}
}

package abc.abc201_250.abc238;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemD別回答Test extends TestBase {

	@Test
	void case1() {
		check("2\n" + "1 8\n" + "4 2", "Yes" + LF + "No");
	}

	@Test
	void case2() {
		check("4\n" + "201408139683277485 381410962404666524\n" + "360288799186493714 788806911317182736\n"
				+ "18999951915747344 451273909320288229\n" + "962424162689761932 1097438793187620758",
				"No" + LF + "Yes" + LF + "Yes" + LF + "No");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc238/D");
	}
}

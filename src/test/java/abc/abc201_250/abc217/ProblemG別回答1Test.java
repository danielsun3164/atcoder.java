package abc.abc201_250.abc217;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemG別回答1Test extends TestBase {

	@Test
	void case1() {
		check("4 2", "0" + LF + "2" + LF + "4" + LF + "1");
	}

	@Test
	void case2() {
		check("6 6", "1" + LF + "31" + LF + "90" + LF + "65" + LF + "15" + LF + "1");
	}

	@Test
	void case3() {
		check("20 5",
				"0" + LF + "0" + LF + "0" + LF + "331776" + LF + "207028224" + LF + "204931064" + LF + "814022582" + LF
						+ "544352515" + LF + "755619435" + LF + "401403040" + LF + "323173195" + LF + "538468102" + LF
						+ "309259764" + LF + "722947327" + LF + "162115584" + LF + "10228144" + LF + "423360" + LF
						+ "10960" + LF + "160" + LF + "1");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("abc217/G");
	}
}

package other.typical90;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class Problem080Test extends TestBase {

	@Test
	void case1() {
		check("4 3\n" + "1 3 4 5", "2");
	}

	@Test
	void case2() {
		check("5 21\n" + "1050624 32772 493952 144 869120", "869120");
	}

	@Test
	void case3() {
		check("20 60\n"
				+ "216181578206878016 81348488767472704 26388280246272 281543729742896 72127981178847488 2199108462600 585610888171487234 22027813536776 567459673280576 146648462866649600 144484898860704776 576471786208755714 4398621196432 144141576657960976 81069330992726040 360851057582278674 17859112 11570646360064 144115206396936193 1702052723957760",
				"977902973481140224");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("typical90/080");
	}
}

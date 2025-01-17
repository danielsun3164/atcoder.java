package other.joi2008yo;

import java.util.Collection;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;

import testbase.TestBase;

class ProblemDTest extends TestBase {

	@Test
	void case1() {
		check("5\n" + "8 5\n" + "6 4\n" + "4 3\n" + "7 10\n" + "0 10\n" + "10\n" + "10 5\n" + "2 7\n" + "9 7\n"
				+ "8 10\n" + "10 2\n" + "1 2\n" + "8 1\n" + "6 7\n" + "6 0\n" + "0 9", "2 -3");
	}

	@Test
	void case2() {
		check("5\n" + "904207 809784\n" + "845370 244806\n" + "499091 59863\n" + "638406 182509\n" + "435076 362268\n"
				+ "10\n" + "757559 866424\n" + "114810 239537\n" + "519926 989458\n" + "461089 424480\n"
				+ "674361 448440\n" + "81851 150384\n" + "459107 795405\n" + "299682 6700\n" + "254125 362183\n"
				+ "50795 541942", "-384281 179674");
	}

	@TestFactory
	Collection<DynamicTest> external() {
		return checkExternal("joi2008yo/D");
	}
}

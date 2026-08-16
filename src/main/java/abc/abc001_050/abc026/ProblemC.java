package abc.abc001_050.abc026;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ProblemC {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			// 社員と部下の一覧のマップ
			Map<Integer, List<Employee>> map = new HashMap<>();
			IntStream.range(1, n).forEach(i -> {
				int boss = scanner.nextInt() - 1;
				List<Employee> list = map.get(boss);
				if (null == list) {
					list = new ArrayList<>();
					map.put(boss, list);
				}
				list.add(new Employee(i));
			});
			System.out.println(calcSalary(0, map));
		}
	}

	/**
	 * @param employeeNo 社員番号
	 * @param map        上司と部下の一覧のマップ
	 * @return 指定された社員番号の給与
	 */
	private static int calcSalary(int employeeNo, Map<Integer, List<Employee>> map) {
		List<Employee> list = map.get(employeeNo);
		if (null == list) {
			// 部下を持たない場合、給与が1
			return 1;
		}
		// 部下を持つ場合、すべての部下の給与を計算
		list.forEach(employee -> {
			employee.salary = calcSalary(employee.employeeNo, map);
		});
		list.sort((a, b) -> a.salary - b.salary);
		// 自分の給与＝部下の給与の最小値+最大値＋1
		return list.get(0).salary + list.get(list.size() - 1).salary + 1;

	}

	/**
	 * 社員を表すクラス
	 */
	private static class Employee {
		/** 社員番号 */
		int employeeNo;
		/** 給与 */
		int salary = 0;

		Employee(int employeeNo) {
			this.employeeNo = employeeNo;
		}
	}
}

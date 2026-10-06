package Learning.StreamAPI;


import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    static void main() {
//        Q1 — filter + map
//        Task: Return a List<Integer> containing only even numbers, with each number multiplied by 3.

        List<Integer> evenNum = List.of(10, 15, 20, 25, 30, 35, 40);
        List<Integer> evenNumbersWithMultipleOf3 = evenNum.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n*3)
                .toList();

        System.out.println(evenNumbersWithMultipleOf3);

//        Q2 — filter + sorted + limit
//        Task: Find the 3 smallest numbers greater than 20.

        List<Integer> smallestAfter20 = List.of( 45, 12, 78, 23, 56, 9, 34, 67, 18);
        List<Integer> smallest3NumAfter20 = smallestAfter20.stream()
                .filter(n -> n > 20)
                .sorted()
                .limit(3)
                .toList();

        System.out.println(smallest3NumAfter20);

//        Q3 — map + distinct
//        Task: Convert every name to uppercase and remove duplicates.

        List<String> distinct = List.of(
                "java", "spring", "java", "docker",
                "spring", "aws", "java"
        );
        List<String> upperCaseAndDistinct = distinct.stream()
                .distinct()
                .map(String::toUpperCase)
                .toList();

        System.out.println(upperCaseAndDistinct);
//    Q4 — flatMap
//    Task: Flatten everything into a single list containing only odd numbers.

        List<List<Integer>> oddList = List.of(
                List.of(1, 2, 3),
                List.of(4, 5),
                List.of(6, 7, 8, 9)
        );
        List<Integer> flattenList = oddList.stream()
                .flatMap(n -> n.stream())
                // can be replaced with method reference List :: stream
                // flattens the List<List<Integer>> -> List<Integer>
                .filter( n -> n % 2 != 0)
                .toList();

        System.out.println(flattenList);

//        Q5 — reduce
//        Task: Calculate the product of all numbers using reduce().

        List<Integer> reduce = List.of(
                5, 10, 15, 20
        );
        int productOfAll = reduce.stream()
                .reduce(1, (multiple,n) -> multiple * n);
        // it has 3 overloading methods
        // reduce(accumulator)
        // reduce(initial, accumulator)
        // reduce(initial, accumulator, combiner) -> for thread based operations

        System.out.println(productOfAll);

//        Q6 — anyMatch, allMatch, noneMatch
//
//        Write three separate Stream expressions to determine:
//        1. Whether at least one number is divisible by 5.
        List<Integer> match = List.of(
                12, 18, 24, 30, 36
        );
        boolean anyMatch = match.stream()
                .anyMatch(n -> n % 5 == 0);

//        2. Whether all numbers are divisible by 6.
        boolean allMatch = match.stream()
                .allMatch(n -> n % 6 == 0);

//        3. Whether no number is negative.
        boolean noMatch = match.stream()
                .noneMatch(n -> n < 0);

        System.out.println(anyMatch);
        System.out.println(allMatch);
        System.out.println(noMatch);

//        Q7 — groupingBy
//        Task: Group employees by department.

        record Employee(
                String name,
                String department,
                List<String> skills,
                int salary
        ) {}

        List<Employee> employees = List.of(
                new Employee("A", "IT", List.of("Java", "SQL"), 50000),
                new Employee("B", "HR", List.of("Excel", "SQL"), 40000),
                new Employee("C", "IT", List.of("Java", "SQL"), 70000),
                new Employee("D", "HR", List.of("Excel", "Communication"), 45000),
                new Employee("E", "Sales", List.of("Excel", "Communication"), 60000),
                new Employee("F", "IT", List.of("Java", "Docker"), 55000)
        );

        Map<String, List<String>> groupByDep = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(
                                Employee::name,
                                Collectors.toList()
                        )
                ));

        System.out.println(groupByDep);

//        Q8 — groupingBy + counting
//        Task: Find the number of employees in each department.

        Map<String, Long> depWiseCount = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.counting()
                ));
        System.out.println(depWiseCount);

//        Q9 — groupingBy + summingInt
//        Task: Calculate the total salary for each department.

        Map<String, Integer> depWiseSalarySum = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.summingInt(Employee::salary)
                ));

        System.out.println(depWiseSalarySum);

//        Q10 — partitioningBy
//        Task: Partition the numbers into:
//        true  -> divisible by 3
//        false -> not divisible by 3

        List<Integer> partitionArr = List.of(
                5, 12, 18, 21, 27, 30, 33, 40
        );

        Map<Boolean, List<Integer>> partition = partitionArr.stream()
                .collect(Collectors.partitioningBy(
                        n -> n % 3 == 0
                ));

        System.out.println(partition);

//        Q11 — toMap + duplicate keys
//        Task:
//        Create: Map<Integer, String>
//
//        where:
//        key   = word length
//                value = word
//
//        There will be duplicate keys.
//        Your solution must handle the duplicate-key situation without throwing an exception.
        List<String> words = List.of(
                "cat", "dog", "apple", "bat", "elephant"
        );

        Map<Integer, String> withDuplicates = words.stream()
                .collect(Collectors.toMap(
                        s -> s.length(),
                        Function.identity(),
                        (oldValue, newValue) -> newValue
                ));

        System.out.println(withDuplicates);

//        Q12 — mapping
//        Task:
//        Produce:
//        Map<String, Set<String>>
//        containing department → employee names.

        Map<String, Set<String>> employeeByDepUsingSet = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(
                            Employee::name,
                            Collectors.toSet()
                        )
                ));

        System.out.println(employeeByDepUsingSet);

//        Q13 — filtering
//        Using the employee list:
//        Task:
//        Create:
//        Map<String, List<Employee>>
//        grouped by department, but each department should contain only employees whose salary is greater than 50,000.
//        Important: perform the filtering inside the downstream collector.

        Map<String, List<Employee>> depWiseEmployeeSalaryAbove50000 = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.filtering(
                            n -> n.salary > 50000,
                            Collectors.toList()
                        )
                ));

        System.out.println(depWiseEmployeeSalaryAbove50000);

//        Q14 — flatMapping
//        Task:
//        Create:
//        Map<String, Set<String>>
//        containing:
//        department -> all unique skills

        Map<String,Set<String>> depWithUniqueSkillSet = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.flatMapping(
                                employee -> employee.skills.stream(), // to give multiple list of skills asa one stream
                                Collectors.toSet() // Collecting it set to store a unique elements
                        )
                ));

        System.out.println(depWithUniqueSkillSet);

//        Q15 — Intermediate vs terminal + lazy evaluation
//        Predict the output before running it:

        List<Integer> predict = List.of(1, 2, 3, 4, 5);

        List<Integer> predicted = predict.stream()
                .filter(n -> {
                    System.out.println("filter " + n);
                    return n > 2;
                })
                .map(n -> {
                    System.out.println("map " + n);
                    return n * 10;
                })
                .findFirst()
                .stream()
                .toList();

        System.out.println(predicted);

//        Q16 — Short-circuiting
//        Write a Stream pipeline that finds the first number greater than 10 that is divisible by 3.
//        Then determine how many elements the pipeline actually needs to inspect.

        List<Integer> shortCircuit = List.of(
                2, 4, 6, 8, 11, 13, 15, 18
        );

        long shortCircuited = shortCircuit.stream()
                .filter(n -> n > 10 && n % 3 == 0)
                .findFirst()
                .stream()
                .count();

        System.out.println(shortCircuited);

    }
}

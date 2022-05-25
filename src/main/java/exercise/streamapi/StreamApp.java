package exercise.streamapi;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static utils.Utils.println;

/**
 * Некоторые примеры использования Stream API
 */
public class StreamApp {

    public static void main(String[] args) {
        mapAndFlatMap();

        collectGroup1();

        collectGroup2();
    }

    //Разница между map() и flatMap
    private static void mapAndFlatMap() {
        String[] data = {"first", "second", "third"};

        List<Stream<String>> mapResult = Stream.of(data)
                .map(StreamApp::enrich)
                .collect(Collectors.toList());

        List<String> flatMapResult = Stream.of(data)
                .flatMap(StreamApp::enrich)
                .collect(Collectors.toList());

        println(flatMapResult);
    }

    private static Stream<String> enrich(String str) {
        return Stream.of(str + "_enriched1", str + "_enriched2", str + "_enriched3");
    }

    //Подсчет кол-ва слов с группировкой по кол-ву букв
    private static void collectGroup1() {
        List<String> words = List.of("AA", "BBB", "C", "DD", "EEEEE", "FF", "G");
        Map<Integer, Long> wordLengthCounter = words.stream()
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));
        println("wordLengthCounter:\n" + wordLengthCounter);
    }

    private static void collectGroup2() {
        List<Employee> employees = List.of(
                new Employee("Ivanov", "developer", 96000),
                new Employee("Petrova", "tester", 77000),
                new Employee("Sidorov", "tester", 81000),
                new Employee("Pupov", "tester", 77000),
                new Employee("Kotova", "developer", 96000)
        );

        Map<String, Map<Integer, List<Employee>>> employeeGroupPosAndSalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getPosition,
                        Collectors.groupingBy(Employee::getSalary)));
        println("employeeGroupPosAndSalary:\n" + employeeGroupPosAndSalary);
    }

    @Getter
    @ToString
    @AllArgsConstructor
    static class Employee {
        private String name;
        private String position;
        private int salary;
    }

}

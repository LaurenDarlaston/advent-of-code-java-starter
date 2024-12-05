package aoc.day02;

import aoc.Day;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day02 extends Day {

    static {
        currentDay = buildCurrentDay(new Object() {
        });
    }

    @Override
    public String part1(List<String> input) {
        List<List<Integer>> inputArray = new ArrayList<>();
        for (String line : input) {
            inputArray.add(splitString(line));
        }

        Integer answer = 0;

        for (List<Integer> array : inputArray) {
            answer += parseReports(array);
        }

        return answer.toString();
    }

    @Override
    public String part2(List<String> input) {
        return null;
    }

    private List<Integer> splitString(String input) {
        return Stream.of(input.split("( {1})")).map(Integer::parseInt).collect(Collectors.toList());
    }

    private int parseReports(List<Integer> input) {
        List<Integer> sortedList = new ArrayList<>(input);
        Collections.sort(sortedList);
        List<Integer> reverseList = new ArrayList<>(sortedList);
        Collections.reverse(reverseList);

        if (sortedList.equals(input) || reverseList.equals(input)) {
            if (checkDifference(input)) {
                return 1;
            }
        }

        return 0;
    }

    private boolean checkDifference(List<Integer> input) {
        for (int i = 0; i < input.size() - 1; i++) {
            int difference = Math.abs(input.get(i) - input.get(i + 1));
            if (!(1 <= difference && difference <= 3)) {
                return false;
            }
        }
        return true;
    }
}

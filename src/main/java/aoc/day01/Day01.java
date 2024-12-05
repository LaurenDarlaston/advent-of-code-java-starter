package aoc.day01;

import aoc.Day;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Day01 extends Day {

    static {
        currentDay = buildCurrentDay(new Object() {});
    }

    @Override
    public String part1(List<String> input) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        sortList(input, list1, list2);

        Integer answer = 0;

        for(int i = 0 ; i < list1.size() ; i++) {
            answer += Math.abs(list1.get(i)-list2.get(i));
        }

        return answer.toString();
    }

    @Override
    public String part2(List<String> input) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        sortList(input, list1, list2);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (Integer integer : list1) {
            if (map.containsKey(integer)) {
                Integer currentNumber = map.get(integer);
                currentNumber += Math.toIntExact(list2.stream().filter(m -> m.equals(integer)).count());
                map.replace(integer, currentNumber);
            } else {
                Integer count = Math.toIntExact(list2.stream().filter(m -> m.equals(integer)).count());
                map.put(integer, count);
            }
        }

        Integer answer = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            answer += entry.getKey() *entry.getValue();
        }
        return answer.toString();
    }


    private List<String> splitString(String input) {
        return List.of(input.split("( {3})"));
    }

    private void sortList(List<String> input, List<Integer> list1, List<Integer> list2) {
        for (String line : input) {
            List<String> splitList = splitString(line);
            list1.add(Integer.parseInt(splitList.get(0)));
            list2.add(Integer.parseInt(splitList.get(1)));
        }

        list1.sort(Integer::compareTo);
        list2.sort(Integer::compareTo);
    }

}

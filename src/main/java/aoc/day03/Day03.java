package aoc.day03;

import aoc.Day;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day03 extends Day {

    static {
        currentDay = buildCurrentDay(new Object() {
        });
    }

    @Override
    public String part1(List<String> input) {

        Pattern pattern = Pattern.compile(" (mul\\(\\d+,\\d+\\)) ");

        List<String> bigList = new ArrayList<>();

        for (String line : input) {
            Matcher matcher = pattern.matcher(line);

            bigList.add(matcher.group());


        }
        return null;
    }

    @Override
    public String part2(List<String> input) {
        return null;
    }
}

package com.algorithm.practice.questions;

import java.util.HashMap;
import java.util.Set;

public class First {
    private static final String OK = "ok";

    public int solution(String[] names, String[] results) {
        HashMap<String, Result> groupMap = createGroupMap(names, results);
        Set<String> groups = groupMap.keySet();
        int successfulGroup = 0;
        for (String group: groups) {
            Result result = groupMap.get(group);
            if (Result.SUCCESSFUL.equals(result)) {
                successfulGroup++;
            }
        }

        return (successfulGroup*100) / groups.size();
    }

    private HashMap<String, Result> createGroupMap(String[] names, String[] results) {
        HashMap<String, Result> groupMap = new HashMap<>();
        for (int i = 0; i < results.length; i++) {
            String name = names[i];
            String resultStr = results[i];
            TestNameParser parser = new TestNameParser(name);
            parser.parse();
            Result result = getResult(resultStr);
            if (groupMap.containsKey(parser.group)) {
                Result existingResult = groupMap.get(parser.group);
                if (Result.SUCCESSFUL.equals(existingResult) && !Result.SUCCESSFUL.equals(result)) {
                    groupMap.put(parser.group, Result.FAILED);
                }
            } else {
                groupMap.put(parser.group, result);
            } 
        }

        return groupMap;
    }

    private Result getResult(String resultStr) {
        return OK.equalsIgnoreCase(resultStr) ? Result.SUCCESSFUL : Result.FAILED;
    }

    private static class TestNameParser {
        private String testName;
        private String taskName;
        private String group;

        private TestNameParser(String testName) {
            this.testName = testName;
        }

        private void parse() {
            group = testName.replaceAll("\\D+","");
            int groupIndex = testName.indexOf(group);
            int groupEndingIndex = groupIndex + group.length();
            if (groupEndingIndex < testName.length()) {
                taskName = testName.substring(groupEndingIndex);
            }
        }
    }

    private enum Result {
        FAILED, SUCCESSFUL
    }
}

package utils;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.Result;
import com.codepine.api.testrail.model.ResultField;
import com.codepine.api.testrail.model.Run;

import java.util.List;

public class TestRailAdapter {
    public static void main(String[] args) {
        TestRail testRail = TestRail.builder("https://resterruster32wis.testrail.io/",
                "samlondon@samlondon.sam","SamLondon!123").applicationName("TestRailIntegration").build();
        Run run = testRail.runs().add(2, new Run().setSuiteId(1).setName("TestRun for AQA10")).execute();
        List<ResultField> customResultFields = testRail.resultFields().list().execute();
        //1 -passed, 2 - blocked, 4 - retest, 5 - failed
        testRail.results().addForCase(run.getId(), 6, new Result().setStatusId(1), customResultFields).execute();
        testRail.results().addForCase(run.getId(), 7, new Result().setStatusId(2), customResultFields).execute();
        testRail.results().addForCase(run.getId(), 8, new Result().setStatusId(4), customResultFields).execute();
        testRail.results().addForCase(run.getId(), 5, new Result().setStatusId(5), customResultFields).execute();
        testRail.runs().close(run.getId()).execute();
    }
}

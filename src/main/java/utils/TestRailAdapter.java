package utils;

import com.codepine.api.testrail.TestRail;
import com.codepine.api.testrail.model.*;

import java.util.List;

public class TestRailAdapter {

    public enum Status{
        PASSED(1), BLOCKED(2), RETEST(4), FAILED(5);
        private int status;

        Status(int status) {
            this.status = status;
        }

        public int getStatus() {
            return status;
        }
    }
    public static TestRail getTestRail() {

        String testRailUrl = "https://resterruster32wis.testrail.io/";
        String username = "samlondon@samlondon.sam";
        String password = "SamLondon!123";
        return TestRail.builder(testRailUrl, username, password)
                .applicationName("TestRailIntegration").build();
    }

    public static Run startTestRun(String nameOfTestRun, int projectId, int suiteId){
        return getTestRail().runs().add(projectId, new Run().setSuiteId(suiteId).setName(nameOfTestRun)).execute();
    }

    public static void setStatusForCaseInTestRun(Status status, int testRunId, int testCaseId){
        List<ResultField> customResultFields = getTestRail().resultFields().list().execute();
        getTestRail().results().addForCase(testRunId, testCaseId, new Result().setStatusId(status.getStatus()), customResultFields).execute();
    }

    public static Run closeRun(int testRunId){
        return getTestRail().runs().close(testRunId).execute();
    }

    public static void getInfoAboutCasesFromProjectInConsole(int idOfProject, int idOfSuite) {
        List<CaseField> caseFieldList = getTestRail().caseFields().list().execute();
        List<Case> listCase = getTestRail().cases().list(idOfProject, idOfSuite, caseFieldList).execute();
        for(Case cases: listCase){
            System.out.println("Id of case: " + cases.getId() + ". Name of case " + cases.getTitle());
        }
    }

    public static void main(String[] args) {
        TestRail testRail = getTestRail();
        getInfoAboutCasesFromProjectInConsole(1,1);
        Run run = testRail.runs().add(1, new Run().setSuiteId(1).setName("Test")).execute();
        setStatusForCaseInTestRun(Status.PASSED, run.getId(), 1);
        testRail.runs().close(run.getId()).execute();
    }

}


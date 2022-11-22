package Atlassian.codingQuestion;

/***
 * https://leetcode.com/discuss/interview-experience/1504593/atlassian-sde-2-p4-september-2021-bangalore-offer
 */
public class Driver {
    public static void main(String[] args) {

        FileUtility  utility = new FileUtility();
        utility.saveFiletoCollection("collection1",200);
        utility.saveFiletoCollection("collection2",200);
        utility.saveFiletoCollection(null,200);

        utility.saveFiletoCollection("collection3",200);
        utility.saveFiletoCollection("collection3",200);
        utility.saveFiletoCollection("collection3",200);
        utility.saveFiletoCollection("collection2",100);
        utility.getTotalSize();
        utility.getTop(3);

    }
}

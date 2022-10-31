package algorithms.exhaustivesearch;

/*
* 모의고사
* 1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
* 2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
* 3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...
* */

public class P42840 {
    public int[] solution(int[] answers) {
        int[] first = {1, 2, 3, 4, 5};
        int[] second = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] answer = new int[3];

        int firstCorrectCnt = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == first[i % first.length]) firstCorrectCnt++;
        }
        answer[0] = firstCorrectCnt;
        System.out.println(firstCorrectCnt);
        return answer;
    }

    public static void main(String[] args) {
        P42840 p42840 = new P42840();
        int[] test = {1,3,2,4,2};

        p42840.solution(test);
    }
}

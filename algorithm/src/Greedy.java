import java.util.Arrays;

public class Greedy {

    /**
     * 1. 체육복 문제
     * https://programmers.co.kr/learn/courses/30/lessons/42862
     * int n         전체 학생 수(2명 이상 30명 이하.)
     * int[] lost    도난당한 학생들 넘버 배열(1명 이상 전체 학생수 이하.)
     * int[] reserve 여벌의 체육복을 가져온 학생들 넘버 배열(1명 이상 전체 학생수 이하. 중복 없음.)
     * 여벌을 가져온 학생이 도난 당한경우 한벌 밖에 남지 않기 때문에 빌려 줄 수 없다.
     */

    /**
     * 1-1 원본
     */
//    public int solution1_1(int n, int[] lost, int[] reserve) {
//        int maxNumber = 0;
//
//        // 1. 내생각대로 풀어보기
//
//        // 1 일반 2 여벌 0 도난
//        int[] studentArr = new int[n];
//
//        // 1 1 1 1 1
//        for (int i = 0; i < studentArr.length; i++) {
//            studentArr[i] = 1;
//        }
//
//        // 1 0 1 0 1
//        for (int i = 0; i < lost.length; i++) {
//            studentArr[lost[i] - 1] = 0;
//        }
//
//        // 2 0 2 0 2
//        for (int i = 0; i < reserve.length; i++) {
//            if (studentArr[reserve[i] - 1] == 0) studentArr[reserve[i] - 1] = 1;
//            else studentArr[reserve[i] - 1] = 2;
//        }
//
//        for (int i = 0; i < studentArr.length; i++) {
//            if (studentArr[i] == 0) {
//                if (i != 0 && studentArr[i - 1] == 2) {
//                    studentArr[i] = 1;
//                    studentArr[i - 1] = 1;
//                } else if (i != (n - 1) && studentArr[i + 1] == 2) {
//                    studentArr[i] = 1;
//                    studentArr[i + 1] = 1;
//                }
//            }
//        }
//
//        for (int i = 0; i < studentArr.length; i++) {
//            if (studentArr[i] > 0) {
//                maxNumber += 1;
//            }
//        }
//
//        return maxNumber;
//    }

    /**
     * 1-2
     * 다른 사람 코드 참고해서 업데이트
     * + 0 기본 배열 사용.
     * maxNumber = n 으로 설정 한뒤 -- 하는 방식 추가.
     * => 숫자대입 아니니까 reserve 셋 할때도 줄어들음..
     * 숫자 매치 대신 ++ -- 사용.
     * n+2 배열 생성시 추가 조건 없어도 가능.
     * => for 문이 두개나 줄었다.
     */
    public static int solution1_2(int n, int[] lost, int[] reserve) {

        int maxNumber = n;

        // 0 일반 1 여벌 -1 도난
        int[] studentArr = new int[n + 2];

        for (int l : lost) {
            studentArr[l]--;
        }

        for (int r : reserve) {
            studentArr[r]++;
        }

        // 마지막은 1 부터..
        // n+2 배열 잡는건 좋은 부분일까..?
        for (int i = 1; i < studentArr.length; i++) {
            if (studentArr[i] == -1) {
                if (studentArr[i - 1] == 1) {
//                    studentArr[i] = 0;
//                    studentArr[i - 1] = 0;
                } else if (studentArr[i + 1] == 1) {
//                    studentArr[i] = 0;
//                    studentArr[i + 1] = 0;
                } else maxNumber--;
            }
        }

        return maxNumber;
    }


    /**
     * 2. 조이 스틱
     * https://programmers.co.kr/learn/courses/30/lessons/42860
     * 알파벳 처음과 마지막 끼리 이동 가능
     * 커서 처음과 마지막 끼리 이동 가능
     */

    /**
     * 2-1 정리 안됨
     * 완전 탈락
     */
//    public int solution2_1(String name) {
//        int upDownCount = 0;
//
//        // 기본 오른쪽
//        boolean doRight = true;
//
//        // 1. 처음의 커서에서 오른쪽 왼쪽 어느곳이 나을지 한방향 A 면 가지않아도 된다.
//        if (Math.abs(name.charAt(name.length() - 1) - 64) == 1) {
//            // 왼쪽
//            doRight = false;
//        }
//
//        // 1 번에서부터 연속적으로 A 거나
//        // n 번에서부터 연속적으로 A 거나
//
//        // 2. A 에서 위로 가까운지 아래로 가까운지 판별.
//        int countMinusStep = 0;
//        if (doRight) {
//            for (int i = 0; i < name.length(); i++) {
//                int fromA = Math.abs(name.charAt(i) - 65);
//                int fromZ = Math.abs(name.charAt(i) - 90) + 1;
//                int check = Math.min(fromA, fromZ);
//                upDownCount += check;
//
//                if (i == 1 && check == 0) countMinusStep--;
//                else if (countMinusStep < 0 && check == 0) countMinusStep--;
//
//
//            }
//        } else {
//            for (int i = name.length() - 1; i <= 0; i--) {
//                int fromA = Math.abs(name.charAt(i) - 65);
//                int fromZ = Math.abs(name.charAt(i) - 90) + 1;
//                int check = Math.min(fromA, fromZ);
//                upDownCount += check;
//
//                if (i == name.length() - 1 && check == 0) countMinusStep--;
//                else if (countMinusStep < 0 && check == 0) countMinusStep--;
//
//            }
//
//        }
//
//        return upDownCount + name.length() + countMinusStep - 1;
//    }

    /**
     * 2-2 역시 정리 안됨
     * 탈락
     */
//    public int solution2_2(String name) {
//        int upDownCount = 0;
//
//        int stepRight = 0;
//        int stepLeft = 0;
//        int reverseStepRight = 0;
//        int reverseStepLeft = 0;
//        int middleACount = 0;
//
//        for (int i = 0; i < name.length(); i++) {
//            int upDown = Math.min(Math.abs(name.charAt(i) - 65), Math.abs(name.charAt(i) - 90) + 1);
//            upDownCount += upDown;
//
//            Boolean isA = upDown == 0;
//
//            if (isA) {
//                middleACount++;
//            } else if (middleACount != 0) {
//                int tempReverseStepRight = (name.length() * 2) - 2 - i - middleACount;
//                int tempReverseStepLeft = (name.length() * 2) - 2 - (name.length() - i) - middleACount;
//
//                if (reverseStepRight == 0) reverseStepRight = tempReverseStepRight;
//                else reverseStepRight = Math.min(reverseStepRight, tempReverseStepRight);
//
//                if (reverseStepLeft == 0) reverseStepLeft = tempReverseStepLeft;
//                else reverseStepLeft = Math.min(reverseStepLeft, tempReverseStepLeft);
//
//                middleACount = 0;
//            }
//
//            if (isA) stepRight--;
//            else stepRight = 0;
//
//            if (!isA) stepLeft = 0;
//            else if (i == 1 && stepLeft < 0) stepLeft--;
//        }
//
//        stepLeft += name.length() - 1;
//        stepRight += name.length() - 1;
//
//        if (reverseStepRight != 0) stepRight = Math.min(stepRight, reverseStepRight);
//        if (reverseStepLeft != 0) stepLeft = Math.min(stepLeft, reverseStepLeft);
//
//        return upDownCount + Math.min(stepRight, stepLeft);
//    }

    /**
     * 2-3 다른 사람 코드 참고함
     * 그렇지만 여전히 예외 케이스 탈락
     */
//    public int solution2_3(String name) {
//        int length = name.length();
//
//        int upDownCount = 0;
//        int turnBack = length - 1;
//        int reTurnBack = length - 1;
//        int straight = length - 1;
//
//        for (int i = 0; i < length; i++) {
//            upDownCount += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
//
//            int next;
//            int count = 0;
//            if (i != 0) {
//                next = i + 1;
//                while (next < length && name.charAt(next) == 'A') {
//
//                    count++;
//
//                    if (next == length - 1) straight = Math.min(straight, length - count - 1);
//
//                    next++;
//                }
//                turnBack = Math.min(turnBack, i + length - count - 1);
//            } else {
//                // 마지막인덱스 부터 가장 가까운 a 들을 찾아야함
//                next = length - 1;
//                int index = 0;
//                while (next > 0) {
//                    if (name.charAt(next) == 'A') {
//                        if (index == 0) index = next;
//                        count++;
//                    } else if (count != 0) {
//                        turnBack = Math.min(turnBack, i + length - count - 1 + index);
//                    }
//                    next--;
//                }
//                turnBack = Math.min(turnBack, i + length - count - 1);
//            }
//        }
//
//        //        String c = numbers;
////
////        int index = 0;
////        int b = numbers.length() - k -1;
////        while (numbers.length() > k){
////            char[] arr = numbers.substring(0 ,  b).toCharArray();
////            Arrays.sort(arr);
////            char a = arr[arr.length - 1];
////            result += a;
////            index = numbers.indexOf(a);
////            numbers = numbers.substring(index + 1);
////        }
////
////        result += numbers.substring(result.length() - result.length());
//
//        // 전체길이 - 버리고싶은 갯수 - 1 의 numbers 에서 가장 큰수를 찾아낸다.
//        // 그 이전의 값들은 버린다.
//        //
//
//        return upDownCount += Math.min(reTurnBack, Math.min(straight, turnBack));
//    }

    /**
     * 2-4 재재재재재도전
     * A 들의 위치를 찾아서 최단 경로 계산
     * 포문 하나만 돌리는걸로 루루루
     * 조금 더 정리할 수 있을거같은데?
     */
    public int solution2_4(String name) {
        int upDownCount = 0;

        int count = 0;
        int minStep = name.length() - 1;
        int startPoint = 0;
        int stopPoint = 0;

        for (int i = 0; i < name.length(); i++) {
            Character c = name.charAt(i);
            upDownCount += Math.min((c - 'A'), ('Z' - c + 1));
            if (c == 'A') {
                if (count == 0) startPoint = i;

                if (i == name.length() - 1) stopPoint = i;
                else stopPoint = 0;
                count++;
            } else {
                if (count != 0) {
                    stopPoint = i - 1;
                    count = 0;
                }
            }

            if (stopPoint != 0) {
                int step = Math.min(
                        startPoint - 1 + ((name.length() - stopPoint - 1) * 2),
                        (startPoint - 1) * 2 + name.length() - stopPoint - 1);
                minStep = Math.min(minStep, step);
            }
        }

        return upDownCount + minStep;
    }


    /**
     * 3. 큰수 찾기
     * https://programmers.co.kr/learn/courses/30/lessons/42883
     * number	k	return
     * "19 24"	2	"94"
     * "1231234"	3	"3234" 4
     * "41 7 7 252841"	4	"775841"
     * 스택을 이용 방법 추가 필요
     */

    /**
     * 3-1 원본
     * 타임아웃
     */
//    public String solution3_1(String numbers, int k) {
//        String result = "";
//
//        int size = numbers.length() - k;
//        int knife = size;
//        while (result.length() < size) {
//            char[] arr = numbers.substring(0, numbers.length() - knife + 1).toCharArray();
////            Arrays.sort(arr);
//            char max = 0;
//            for (int i = 0; i < arr.length - 1; i++) {
//                if (arr[i] > arr[i + 1]) max = arr[i];
//                else max = arr[i + 1];
//            }
//            result += max;
//            numbers = numbers.substring(numbers.indexOf(max) + 1);
//            knife--;
//        }
//
//        return result;
//    }

    /**
     * 3-2 타임아웃 해결본
     * 그래도 여전히 느리다.
     */
    public String solution3_2(String number, int k) {
        StringBuilder sb = new StringBuilder(number);
        StringBuilder result = new StringBuilder();

        int size = sb.length() - k;
        int knife = size;
        int point = 0;
        while (result.length() < size) {
            char max = 0;
            for (int i = point; i < sb.length() - knife + 1; i++) {
                if (sb.charAt(i) > max) {
                    max = sb.charAt(i);
                    point = i + 1;
                }
            }
            result.append(max);
            knife--;
        }

        return result.toString();
    }


    /**
     * 4. 섬 건너기
     * https://programmers.co.kr/learn/courses/30/lessons/42885
     * people	limit	return
     * [70, 50, 80, 50]	100	3
     * [70, 80, 50]	100	3
     * @param people
     * @param limit
     * @return
     */

    /**
     * 4-1 원본
     * 포문 두개나 돌림..
     * 왜 그랬죠
     */
//    public int solution4_1(int[] people, int limit) {
//        int answer = 0;
//        int front = 0;
//
//        Arrays.sort(people);
//
//        for (int i = people.length - 1; i >= front; i--) {
//            for (int j = front; j <= i; j++) {
//                if (people[j] + people[i] <= limit) {
//                    answer++;
//                    front = j + 1;
//                    break;
//                } else {
//                    answer++;
//                    break;
//                }
//            }
//        }
//
//        return answer;
//    }

    /**
     * 4-2 수정본
     * 코드 길이가 줄어드니 좋다.
     */
    public int solution4_2(int[] people, int limit) {
        int answer = 0;
        int front = 0;

        Arrays.sort(people);

        for (int i = people.length - 1; i >= front; i--) {
            if (people[i] + people[front] <= limit) front++;
            answer++;
        }

        return answer;
    }


    /**
     * @param n     섬의 갯수
     * @param costs 섬1 섬2 cost
     * @return
     */
    public int solution(int n, int[][] costs) {
        int answer = 0;

        return answer;
    }

}

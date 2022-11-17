package algorithms.primenumber;

public class LogicFlow {
    public void logicFlow(int[] arr) {
        /* 2를 제외한 2의 배수 모두 0으로 바꾸기 */
        for (int i = 2; i < arr.length; i += 2) {
            arr[i] = 0;
        }
        /*3의 배수*/
        for (int i = 4; i < arr.length; i += 3) {
            arr[i] = 0;
        }
        /*4의 배수*/
        for (int i = 6; i < arr.length; i += 2) {
            arr[i] = 0;
        }

    }

    public static void main(String[] args) {
        for (int i = 0; i < 51; i++) {
            
        }
    }
}

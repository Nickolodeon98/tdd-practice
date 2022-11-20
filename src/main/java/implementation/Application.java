package implementation;

public class Application {
    public static void main(String[] args) {
        if (args.length > 0) {
            if (CommandLineFlags.HELP.getValue().equals(args[0])) System.out.println("도움말 옵션 사용");
            if (CommandLineFlags.DEBUGGING.getValue().equals(args[0])) System.out.println("디버깅 옵션 사용");
            if (CommandLineFlags.VERSION.getValue().equals(args[0])) System.out.println("버전 확인 옵션 사용");
            if (CommandLineFlags.DIRECTORY.getValue().equals(args[0])) System.out.println("디렉토리 지정 옵션 사용");
        }

//        for (CommandLineFlags value : CommandLineFlags.values()) {
//            if (value.getValue().equals(args[1])) System.out.println(value.getMessasge());
//        }

        System.out.println(CommandLineFlags.HELP.ordinal());
    }
}

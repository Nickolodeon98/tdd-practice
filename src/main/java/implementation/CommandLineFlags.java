package implementation;

public enum CommandLineFlags {
    DEBUGGING("-g", "디버깅 옵션 사용"),
    HELP("-help", "도움말 옵션 사용"),
    VERSION("-version", "버전 확인 옵션 사용"),
    DIRECTORY("-d", "디렉토리 지정 옵션 사용");

    private String value;
    private String messasge;

    CommandLineFlags(String value, String messasge) {
        this.value = value;
        this.messasge = messasge;
    }

    public String getValue() {
        return value;
    }

    public String getMessasge() {
        return messasge;
    }
}

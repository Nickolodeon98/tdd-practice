package sql.dao;

public class Local {
    private String awsConnectUrl;
    public Local() {
        this.awsConnectUrl = "jdbc:mysql://localhost:3306/likelion-db";
    }

    public String getAwsConnectUrl() {
        return awsConnectUrl;
    }
}

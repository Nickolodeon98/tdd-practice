package sql.dao;

public class AWSDo {
    private String awsConnectUrl;
    public AWSDo() {
        this.awsConnectUrl = "jdbc:mysql://ec2-3-35-224-74.ap-northeast-2.compute.amazonaws.com:3306/likelion-db";
    }

    public String getAwsConnectUrl() {
        return awsConnectUrl;
    }
}

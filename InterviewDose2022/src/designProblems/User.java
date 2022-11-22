package designProblems;

public class User {


    public void setWindowNum(long windowNum) {
        this.windowNum = windowNum;
    }

    public void setRequestCount(long requestCount) {
        this.requestCount = requestCount;
    }

    private long windowNum;
    private long requestCount;
    public long getWindowNum() {
        return windowNum;
    }

    public long getRequestCount() {
        return requestCount;
    }

    User(long windowNum)
    {
        this.windowNum = windowNum;
        this.requestCount = 1;
    }

    void reset(long windowNum)
    {
        this.windowNum = windowNum;
        this.requestCount = 0;
    }
}

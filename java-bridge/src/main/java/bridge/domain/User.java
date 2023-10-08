package bridge.domain;

import java.util.List;

public class User {

    private int currentCount;
    private List<String> bridge;


    public User() {
        this.currentCount = 1;
    }

    public void setCurrentCount(int currentCount) {
        this.currentCount = currentCount;
    }

    public void setBridge(List<String> bridge) {
        this.bridge = bridge;
    }

    public int getCurrentCount() {
        return this.currentCount;
    }
}

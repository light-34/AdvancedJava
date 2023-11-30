package org.adv.lists;

public class ErrorCount {
    private int error = 0;

    public ErrorCount() {
    }

    public void addError(int number) {
        this.error += number;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}

package com.example.testframeworkwi2020c;

public class TestResult<T> {
    private boolean success;
    private T returnValue;

    public TestResult(boolean success, T returnValue) {
        this.success = success;
        this.returnValue = returnValue;
    }

    public boolean isSuccess() {
        return success;
    }

    public T getReturnValue() {
        return returnValue;
    }
}

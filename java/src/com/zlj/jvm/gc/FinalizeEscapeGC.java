package com.zlj.jvm.gc;

public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive(){
        System.out.println("yes, i am stall alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}

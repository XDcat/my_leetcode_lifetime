package com.zlj.jvm.heap;

public class Demo01 {
    public static void main(String[] args) {
        int size = 1024 * 1024;
        int memorySize = 16 * 1024;  // 16 GB
        long maxMemory = Runtime.getRuntime().maxMemory() / size;
        long totalMemory = Runtime.getRuntime().totalMemory() / size;
        System.out.printf("MaxMemory: %d MB, TotalMemory: %d MB\n", maxMemory, totalMemory);
        // System.out.printf("MaxMemory: %.2f, TotalMemory: %.2f MB\n", memorySize / 4.0, memorySize / 64.0);
    }
}

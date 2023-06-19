package com.zlj.javabasic.array;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        // basic type
        System.out.println("------ Basic ------");
        System.out.println("Array to List");
        int[] nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        System.out.println("List to Array");
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());
        int[] array1 = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(array1));

        // object
        System.out.println("------ Object ------");
        System.out.println("Array to List");
        String[] strings = "hello world my name is cat".split("\\s");
        List<String> list2 = List.of(strings);
        System.out.println(list2);

        System.out.println("List to Array");
        String[]  array2 = list2.toArray(new String[list2.size()]);
        System.out.println(Arrays.toString(array2));
    }
}

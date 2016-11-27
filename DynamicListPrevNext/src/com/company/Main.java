package com.company;

public class Main {

    public static void main(String[] args) {
	DynamicList dynamicListTest= new DynamicList();

        String test="item three"; //item that will be tested with

        dynamicListTest.add("item one");
        dynamicListTest.add("item two");
        dynamicListTest.add("item three");
        dynamicListTest.add("item four");
        dynamicListTest.add("item five");
        dynamicListTest.add("item six");

        System.out.println("Testing with '"+ test + "' .Testing variable can be changed in the main method!");
        System.out.println();
        System.out.println("List size before any operations done:");
        System.out.println(dynamicListTest.getLength());
        System.out.println();
        System.out.println("Contains and indexOf functions check for '" +test+"':");
        System.out.println(dynamicListTest.contains(test));
        System.out.println(dynamicListTest.indexOf(test));
        System.out.println();
        System.out.println("ElementAt function check for '"+test+"':");
        System.out.println(dynamicListTest.elementAt(dynamicListTest.indexOf(test)));
        System.out.println();
        System.out.println("indexRemove function check for '"+test+"'. New Length:");
        dynamicListTest.indexRemove(dynamicListTest.indexOf(test));
        System.out.println(dynamicListTest.getLength());
        System.out.println();
        System.out.println("Add function check for '"+test+"'. New Length:");
        dynamicListTest.add(test);
        System.out.println(dynamicListTest.getLength());
        System.out.println();
        System.out.println("valueRemove function check for '"+test+"'. New Length:");
        dynamicListTest.valueRemove(test);
        System.out.println(dynamicListTest.getLength());


    }
}

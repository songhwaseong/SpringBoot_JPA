package com.study.develop.service;

public class JavaTest {
    public static void main(String[] args){
        /*MyFunction f  = new MyFunction(){     //오버라이딩 - 접근제어자는 좁게 못바꾼다
            public int max(int a, int b){
                return a > b ? a : b;
            }
        };*/
        MyFunction f  = (a, b) -> a > b ? a : b;
        int value = f.max(3,5);
        System.out.println(value);
        System.out.println(value);
        System.out.println(value);
    }
}

@FunctionalInterface    //함수형 인터페이스는 단 하나의 추상 메서드만 가져야함
interface MyFunction{
    abstract int max(int a, int b);
}
package com.fish.base.exception;

public class ExceptionMain {
    public static void main(String[] args) {
        try {
            Biztest biztest = new Biztest();
            biztest.test(2);
        } catch (BizException e) {
            System.out.println(e);
        } catch (RuntimeException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

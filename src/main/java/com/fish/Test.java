package com.fish;

public class Test {
    private String name;

    public Test(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static void main(String[] args) {
        String str = "收件人邮编(96822)不符合美国邮编规范或渠道不支持该地区:guid=J0100000000000584172";

        // 收件人邮编(96822)不符合美国邮编规范或渠道不支持该地区:guid=J0100000000000584172
        String ddl = "J0100000000000584172";
        String replaceStr = ":guid=" + ddl;

        System.out.println(str.replace(replaceStr,""));
    }
}

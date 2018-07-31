package com.demo.character;

public class CharacterDemo {

    public static void main(String [] args) {

        String chinese = "中";
        String english = "A";
        String cha = "0x20001";
        int c = 0x20001;
        CharacterDemo.characterTest(english);
        System.out.println("=============以上是英文字符输出信息=================");

        CharacterDemo.characterTest(chinese);
        System.out.println("=============以上是中文字符输出信息=================");

        CharacterDemo.characterTest(cha);
        System.out.println("==========================================");

        CharacterDemo.binaryTest(c);
        System.out.println("==========================================");
    }

    private static void characterTest(String str) {
        CharacterDemo.getLengthByEncodeing(str,"GB2312");
        CharacterDemo.getLengthByEncodeing(str,"GBK");
        CharacterDemo.getLengthByEncodeing(str,"GB2312");
        CharacterDemo.getLengthByEncodeing(str,"GB18030");
        CharacterDemo.getLengthByEncodeing(str,"ISO-8859-1");
        CharacterDemo.getLengthByEncodeing(str,"UTF-8");
        CharacterDemo.getLengthByEncodeing(str,"UTF-16");
        CharacterDemo.getLengthByEncodeing(str,"UTF-16BE");
        CharacterDemo.getLengthByEncodeing(str,"UTF-16LE");
    }

    private static void binaryTest(int c) {
        char[] arr = Character.toChars(c);
        String s = new String(arr);
        System.out.println("char array length:" + arr.length);
        System.out.println("content:|  " + s + " |");
        System.out.println("String length:" + s.length());

        CharacterDemo.getLengthByEncodeing(s, "GB2312");
        CharacterDemo.getLengthByEncodeing(s, "GBK");
        CharacterDemo.getLengthByEncodeing(s, "GB2312");
        CharacterDemo.getLengthByEncodeing(s, "GB18030");
        CharacterDemo.getLengthByEncodeing(s, "ISO-8859-1");
        CharacterDemo.getLengthByEncodeing(s, "UTF-8");
        CharacterDemo.getLengthByEncodeing(s, "UTF-16");
        CharacterDemo.getLengthByEncodeing(s, "UTF-16BE");
        CharacterDemo.getLengthByEncodeing(s, "UTF-16LE");
    }

    private static void getLengthByEncodeing(String str, String encodingName) {
        try {
            System.out.format("编码格式：%s\t\t", encodingName);
            System.out.format("字节长度：%s\n",str.getBytes(encodingName).length);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}

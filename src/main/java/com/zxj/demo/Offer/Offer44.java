package com.zxj.demo.Offer;

import java.util.Stack;

/**
 * Created by upc on 2019/9/12.
 */
public class Offer44 {
    /**
     * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，有一天他向Fish借来翻看，但却读不懂它的意思。
     * 例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
     *
     * @param str
     * @return
     */
    public String ReverseSentence(String str) {
        if(str==null||str.equals("")||str.trim().equals(""))return str;
        String[] temp=str.trim().split(" ");
        Stack<String> stack=new Stack<>();
        stack.push(temp[0]);
        for(int i=1;i<temp.length;i++){
            stack.push(temp[i]+" ");
        }
        String result="";
        while(!stack.isEmpty()){
            result+=stack.pop();
        }
        return result;
    }
}

package com.DaC.LeetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class: "LeetCode022"
 * 谌杰:chenjie15@foxmail.com
 * Date： 2020-08-14 18:07
 * Description:
 */
public class LeetCode022 {
    public static void main(String[] args) {
        System.out.println(generateParenthesis2(4));
    }

    public static List<String> generateParenthesis(int n) {
        //递归法
        Set<String> res = new HashSet<String>();
        if(n==1) {
            res.add("()");
            return new ArrayList(res);
        }
        List<String> temp = generateParenthesis(n-1);
        // 一个括号，和n-1个括号的组合
        for (int i = 0; i < temp.size(); i++) {
            res.add("("+temp.get(i)+")");
            res.add("()"+temp.get(i));
            res.add(temp.get(i)+"()");
        }
        //2块拼一起
        for (int j = 2; j <=n/2 ; j++) {
            List<String> temp1 = generateParenthesis(j);
            List<String> temp2 = generateParenthesis(n-j);
            for (int i = 0; i <temp1.size() ; i++) {
                for (int k = 0; k < temp2.size(); k++) {
                    res.add(temp1.get(i)+temp2.get(k));
                    res.add(temp2.get(k)+temp1.get(i));
                }
            }
        }
        return new ArrayList(res);
    }

    public static List<String> generateParenthesis2(int n) {
        //回溯法
        ArrayList<String> res = new ArrayList<>();
        backtracking(res,"", 0, 0, n);
        return res;
    }

    public static void backtracking(List<String> list, String str, int left, int right, int max){
        if(right==max){
            list.add(str);
        }
        if(left<max)
            backtracking(list,str+"(",left+1,right,max);
        if(right<left)
            backtracking(list,str+")",left,right+1,max);
    }


}

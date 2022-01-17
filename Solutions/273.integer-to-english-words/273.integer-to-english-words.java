/*
 * @lc app=leetcode id=273 lang=java
 *
 * [273] Integer to English Words
 */
class Solution {
    public String numberToWords(int num) {
        String res = changeHundred(num%1000);
        String[] radix = {"Thousand","Million","Billion"};
        for(int i = 0; i<3;i++){
            num /= 1000;
            res = num %1000 == 0?res:changeHundred(num%1000) + " "+radix[i]+" "+res;
        }
        return res.trim().length() == 0 ? "Zero" : res.trim(); 
    }

    public String changeHundred(int num){
        String[] v1 = {"","One","Two","Three","Four","Five","Six",
                        "Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen",
                        "Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
        String[] v2 = {"", "", "Twenty", "Thirty", "Forty", "Fifty", 
                        "Sixty", "Seventy", "Eighty", "Ninety"};
        int a = num / 100, b = num % 100, c = num %10;
        String res;
        if(b < 20){
            res = v1[b];
        }else{
            res = v2[b / 10] + (c!=0?" "+ v1[c]:"");
        }
        if(a > 0){
            res = v1[a] + " Hundred" + (b!=0?" "+res:"");
        }
        return res;
    }
}


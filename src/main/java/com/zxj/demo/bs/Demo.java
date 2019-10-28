package com.zxj.demo.bs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by upczh on 2019/8/26.
 */
public class Demo {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /**
     * 当然，你也可以不按照这个模板来作答，完全按照自己的想法来
     **/
    public static String measureDistance(List<Double> xList, List<Double> yList, double x, double y) {
        double xmax=xList.get(0),ymax=xList.get(0),xmin=yList.get(0),ymin=yList.get(0);
        for(int i=1;i<xList.size();i++){
            if(xList.get(i)>xmax){
                xmax=xList.get(i);
            }
            if(xList.get(i)<xmin){
                xmin=xList.get(i);
            }
            if(yList.get(i)>ymax){
                ymax=yList.get(i);
            }
            if (yList.get(i)<ymin){
                ymin=yList.get(i);
            }
        }
        if(x>=xmin&&x<=xmax&&y<=ymax&&y>=ymin){
            return "yes,0";
        }else {
            if(y>ymax){
                if(x>=xmin&&x<=xmax){
                    return "no,"+String.format("%.0f",y-ymax);
                }else {
                    if(x>xmax){
                        return "no,"+String.format("%0.f",Math.sqrt(Math.pow(xList.get(2)-x,2)+Math.pow(yList.get(2)-y,2)));
                    }else {
                        return "no,"+String.format("%0.f",Math.sqrt(Math.pow(xList.get(1)-x,2)+Math.pow(yList.get(1)-y,2)));
                    }
                }
            }else if(y<ymin){
                if(x>=xmin&&x<=xmax){
                    return "no,"+String.format("%.0f",ymin-y);
                }else {
                    if(x>xmax){
                        return "no,"+String.format("%0.f",Math.sqrt(Math.pow(xList.get(3)-x,2)+Math.pow(yList.get(3)-y,2)));
                    }else {
                        return "no,"+String.format("%0.f",Math.sqrt(Math.pow(xList.get(0)-x,2)+Math.pow(yList.get(0)-y,2)));
                    }
                }
            }else {
                if(x<xmin){
                    return "no,"+String.format("%.0f",xmin-x);
                }else {
                    return "no,"+String.format("%.0f",x-xmax);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        //(x,y)为小广所在的位置
        double x = Double.parseDouble(line.split(",")[0]);
        double y = Double.parseDouble(line.split(",")[1]);

        line = in.nextLine();
        //xList记录了多边形n个点的x坐标,yList记录了多边形n个点的y坐标
        List<Double> xList = new ArrayList<>();
        List<Double> yList = new ArrayList<>();
        String[] array = line.split(",");
        for(int i = 0; i < array.length; i++) {
            xList.add(Double.parseDouble(array[i]));
            yList.add(Double.parseDouble(array[i+1]));
            i++;
        }
        in.close();
        System.out.println(measureDistance(xList, yList, x, y));
    }
}

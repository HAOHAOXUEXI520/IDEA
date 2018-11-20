package renwu;
class Y{
    private double radius;
    static int numberofcircles;
    private boolean shuru=false;

     Y(){
        numberofcircles++;
        display();
    }
      Y(double r){
          shuru=true;
        numberofcircles++;
        this.radius=r;
       display();
    }
    String getRadius(){
        if(shuru==false) return "未输入";
        return  Double.toString(this.radius);
    }
    void setRadius(double r){
        this.radius=r;
    }
    int getNumberofcircles(){
        return numberofcircles;
    }
    String area(){
        if(radius<=0)return "不可计算";
        return String.format("%.2f",Math.PI*Math.pow(radius,2));

    }
    String Perimeter(){
        if(radius<=0)return "不可计算";
        return String.format("%.2f",2*Math.PI*radius);
    }
    void display(){
        System.out.printf("构造第%d个圆，半径为：%s，面积为：%s，周长为%s",getNumberofcircles(),getRadius(),area(),Perimeter());
        System.out.println();
    }

};
public class Yuan{
public static void main(String args[]){
     Y bj[]={new Y(),new Y(-1),new Y(0.0),new Y(5.0),new Y(200.0)};
  }
}
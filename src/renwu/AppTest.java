package zhengli;
import java.util.Scanner;

abstract class Geometry
{
    abstract double getArea();
    abstract double getCircum();
}
class Pillar
{
    Geometry xu;
    public double h;
    public void fuzhi(Geometry xu,double h)
    {
        this.xu=xu;
        this.h=h;
    }
    public double getVolume()
    {
        return xu.getArea()*h;
    }
    public double getAreas()
    {
        return 2*xu.getArea()+xu.getCircum()*h;

    }
}
class circle extends Geometry
{
    private double r;

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    double getArea() {
        return Math.PI*Math.pow(r, 2);
    }

    @Override
    double getCircum() {
        return 2*Math.PI*r;
    }


}
class rectangle extends Geometry
{
    private double length;
    private double width;
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }
    @Override
    double getArea() {
        return this.length*this.width;
    }
    @Override
    double getCircum() {
        return 2*(this.length+this.width);
    }
}
class square extends Geometry
{
    private  double bianchang;

    public double getBianchang() {
        return bianchang;
    }

    public void setBianchang(double bianchang) {
        this.bianchang = bianchang;
    }

    @Override
    double getArea() {
        return Math.pow(bianchang,2);
    }

    @Override
    double getCircum() {
        return 4*bianchang;
    }
}
class triangle extends Geometry
{
    private double first;
    private double second;
    private double third;
    public double getFirst() {
        return first;
    }
    public void setFirst(double first) {
        this.first = first;
    }
    public double getSecond() {
        return second;
    }
    public void setSecond(double second) {
        this.second = second;
    }
    public double getThird() {
        return third;
    }
    public void setThird(double third) {
        this.third = third;
    }
    @Override
    double getArea() {
        double circum=this.getCircum()/2;
        return Math.sqrt(circum*(circum-first)*(circum-second)*(circum-third));
    }
    @Override
    double getCircum() {
        return first+second+third;
    }
}
public class AppTest {
    public static void main(String[] args)
    {
        Scanner p=new Scanner(System.in);
        Pillar a=new Pillar();
        while (true) {
            System.out.print("1.圆柱\n2.矩柱\n3.三角柱\n4.正方柱\n5.退出\n");
            System.out.print("请输入以上选项：");
            String r = p.next();
            switch (r) {
                case "1": {
                    double banji[] = {1, 15, 30, 100};
                    circle t = new circle();
                    for (int i = 1; i <= 4; i++) {
                        while (true) {
                            System.out.print("请输入第" + i + "个圆柱的高：");
                            double h = p.nextDouble();
                            if (h <= 0) System.out.println("请输入正数！");
                            else {
                                t.setR(banji[i - 1]);
                                a.fuzhi(t, h);
                                System.out.printf("第%d个：底面积半径为：%.2f,高为：%.2f,圆柱的表面积为：%.2f，圆柱的体积为：%.2f\n\n\n", i,t.getR(), h, a.getAreas(), a.getVolume());
                                break;
                            }
                        }
                    }
                }
                break;
                case "2": {
                    double z, g, h;
                    rectangle t = new rectangle();
                    for (int i = 1; i <= 4; i++) {
                        while (true) {
                            System.out.print("输入第"+i+"个矩柱的长：");
                            z = p.nextDouble();
                            if (z <= 0) System.out.println("请输入正数！");
                            else {
                                break;
                            }
                        }
                        t.setLength(z);
                        while (true) {
                            System.out.print("输入第"+i+"个矩柱的宽：");
                            g = p.nextDouble();
                            if (g <= 0) System.out.println("请输入正数！");
                            else {
                                break;
                            }
                        }
                        t.setWidth(g);
                        while (true) {
                            System.out.print("输入第"+i+"个矩柱的高：");
                            h = p.nextDouble();
                            if (h <= 0) System.out.println("请输入正数！");
                            else {
                                break;
                            }
                        }
                        a.fuzhi(t, h);
                        System.out.printf("第%d个：底面积长为：%.2f,底面积宽为：%.2f,高为：%.2f,矩柱的表面积为：%.2f，矩柱的体积为：%.2f\n\n\n",i, t.getLength(), t.getWidth(),h, a.getAreas(), a.getVolume());
                    }
                }
                break;
                case "3": {
                    double z, g, l, h;
                    triangle m = new triangle();
                    for (int i = 1; i <= 4; i++) {
                        while (true) {
                            while (true) {
                                System.out.print("输入第"+i + "个三角柱的第一边长：");
                                z = p.nextDouble();
                                if (z <= 0) System.out.println("请输入正数！");
                                else {
                                    break;
                                }
                            }
                            while (true) {
                                System.out.print("输入第" + i + "个三角柱的第二边长：");
                                g = p.nextDouble();
                                if (g <= 0) System.out.println("请输入正数！");
                                else {
                                    break;
                                }
                            }

                            while (true) {
                                System.out.print("输入第" + i + "个三角柱的第三边长：");
                                l = p.nextDouble();
                                if (l <= 0) System.out.println("请输入正数！");
                                else {
                                    break;
                                }
                            }
                            if((g+z>l&&l>Math.abs(g-z))&&((g+l>z)&&z>Math.abs(g-l))&&((l+z)>g)&&g>Math.abs(l-z))
                            {
                                break;
                            }
                            else
                            {
                                System.out.println("这不是三角形！");
                            }
                        }
                        m.setFirst(z);
                        m.setSecond(g);
                        m.setThird(l);
                        while (true) {
                            System.out.print("输入第"+"个三角柱的高：");
                            h = p.nextDouble();
                            if (h <= 0) System.out.println("请输入正数！");
                            else {
                                break;
                            }
                        }
                        a.fuzhi(m, h);
                        System.out.printf("第%d个：底面积第一边长为：%.2f,底面积第二边长为：%.2f,底面积第三边长为：%.2f，高为：%.2f,三角柱的表面积为：%.2f，三角柱的体积为：%.2f\n\n\n",i, m.getFirst(), m.getSecond(), m.getThird(), h, a.getAreas(), a.getVolume());
                    }
                }
                break;
                case "4": {
                    double z,h;
                    square t = new square();
                    for (int i = 1; i <= 4; i++) {
                        while (true) {
                            System.out.print("输入第"+i+"个正方柱棱长为：");
                            z = p.nextDouble();
                            if (z <= 0) System.out.println("请输入正数！");
                            else break;
                        }
                        t.setBianchang(z);
                        while (true)
                        {
                            System.out.print("输入第"+i+"个正方柱高为：");
                            h=p.nextDouble();
                            if (h <= 0) System.out.println("请输入正数！");
                            else break;
                        }
                        a.fuzhi(t,h);
                        System.out.printf("第%d个：棱长为：%.2f,高为：%.2f,正方柱的表面积为：%.2f，正方柱的体积为：%.2f\n\n\n",i, t.getBianchang(), h, a.getAreas(), a.getVolume());
                    }
                }
                break;
                case "5":
                    System.exit(0);
                default:
                    System.out.println("没有这种选项！");
            }
            System.out.println();
        }
    }
}

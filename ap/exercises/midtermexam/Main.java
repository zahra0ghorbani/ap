package ap.exercises.midtermexam;


public class Main {
    public static void main(String[] args) {
        Pc pc1 = new Pc(100,"blue",15.6f,1000);
        Pc pc2 = new Pc(200,"green",15.6f,1500);
        Case case1 =new Case(1000,"black",1,12000);
        Case case2 =new Case(2000,"green",1,8000);


        Shop shop = new Shop();
        shop.addPc(pc1);
        shop.addPc(pc2);
        shop.addCase(case1);
        shop.addCase(case2);

        shop.printPcList();
        shop.printCaseList();

        Pc pc3 = new Pc(100,"red",15.6f,1000);
        shop.addPc(pc3);

        Case case3 = new Case(1000,"black",1,12000);
        shop.addCase(case3);

        shop.removePc(pc3);
        shop.removeCase(case3);

        System.out.println(pc1);
        System.out.println(pc2);
        System.out.println(case1);
        System.out.println(case2);



    }
}

package com.ohgiraffers.section04.interfacesegregation.resolved;

public class Application {
    public static void main(String[] args) {
        PrintOnly bp = new BasicPrinter();
        bp.print();

        MultiFunctionPrinter ap = new AdvancedPrinter();
        ap.print();
        ap.fax();
        ap.scan();
    }
}

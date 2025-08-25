package com.ohgiraffers.section04.interfacesegregation.resolved;

public interface MultiFunctionPrinter extends FaxMachine, PrintOnly, Scanner {
    @Override
    void fax();

    @Override
    void print();

    @Override
    void scan();
}

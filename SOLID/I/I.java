
//Interface segregation principle.

class Document{

}
interface Machine{
    void print(Document d);
    void scan(Document d);
    void fax(Document d);
}

class MultifunctionalPrinter implements Machine{

    @Override
    public void print(Document d) {
        // TODO Auto-generated method stub

    }

    @Override
    public void scan(Document d) {
        // TODO Auto-generated method stub

    }

    @Override
    public void fax(Document d) {
        // TODO Auto-generated method stub

    }
    
}

class OldPrinter implements Machine{

    @Override
    public void print(Document d) {
        // TODO Auto-generated method stub

    }

    @Override
    public void scan(Document d) {
        // This function is of no use to us and can create a descrepency in case of the user/client - feels like this function can be implmented. 
        // Solution 1 - leave it empty - problem - can give a feeling that this woks as the function is present
        // Solution 2 - throw exception - problem - we need to handle it in a proper manner and this exception needs to be carried on to the interface as well
        // BEST SOLUTION - Independent interface usage - i.e separate interface for print,scan,fax and implments only those interfaces that are needed.

    }

    @Override
    public void fax(Document d) {
        // Same as scan

    }
    
}

interface Printer{
    void print(Document d);
}

interface Scanner{
    void scan(Document d);
}

interface Fax{
    void fax(Document d);
}


class PrinterAndScanner implements Printer,Scanner{

    //We implement only the functions that are needed. 

    @Override
    public void scan(Document d) {
        // TODO Auto-generated method stub

    }

    @Override
    public void print(Document d) {
        // TODO Auto-generated method stub

    }

}

// we have also make another interface that is a combination of multiple single interfaces.

interface ModernPrinter extends Printer,Scanner,Fax{

}

class myPersonalModernPrinter implements ModernPrinter{

    @Override
    public void print(Document d) {
        // TODO Auto-generated method stub

    }

    @Override
    public void scan(Document d) {
        // TODO Auto-generated method stub

    }

    @Override
    public void fax(Document d) {
        // TODO Auto-generated method stub

    }
    
}

class I{

}
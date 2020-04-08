

class Customer {

    public String name;
    public String lastname;
    public String address;

    public Customer(String name, String lastname, String address) {
        this.name = name;
        this.lastname = lastname;
        this.address = address;
    }

    @Override
    public String toString() {
        return "Name -"+name+" LastName - "+lastname+" Address - "+address;
    }

    
}

class CustomerBuilder{
    private String name;
    private String lastname;
    private String address;

    public CustomerBuilder setName(String name) {
        this.name = name;
        return this;
    }
    
    public CustomerBuilder setLastName(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public CustomerBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Customer build(){
        return new Customer(name,lastname,address);
    }
}

class MakeNewCustomers{
    public static void main(String  args[]) {
        Customer c = new CustomerBuilder().setName("Ajinkya").setLastName("Pathak").build();

        System.out.println(c);
        
    }
}
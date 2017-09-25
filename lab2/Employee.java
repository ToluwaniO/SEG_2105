public class Employee
{
    private String name;
    private int hours;
    private double rate;
    private Address[] address=new Address[5];

    public Employee(String name, int hours, double rate, Address[] address)
    {
        this.name = name;
        this.hours = hours;
        this.rate = rate;
        this.address = address;
    }

    public static void main(String[] args)
    {
        Address a = new Address("Queen", 48, "K1P1N2");
        Address b = new Address("King Edward", 800, "K1N6N5");
        Address[] addresses=new Address[5];
        addresses [0]=a;
        addresses [1]=b;
        Employee faleo = new Employee("Faleo", 40, 15.50, addresses);
    }
}

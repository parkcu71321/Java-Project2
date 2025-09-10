package q0910;

import java.util.ArrayList;

public class ListPersonTest
{
    public static void main(String[] args)
    {
        Person p1 = new Person("샤를 르클레르",23,"남");
        Person p2 = new Person("막스 베르스타펜",24,"남");
        Person p3 = new Person("루이스 해밀턴",25,"남");

        ArrayList<Person> persons = new ArrayList<Person>();

        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        PrintPerson pp = new PrintPerson();

        pp.print(persons);
    }
}

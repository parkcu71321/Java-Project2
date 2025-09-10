package q0910;

import java.util.List;

public class PrintPerson
{
    public void print(List<Person> persons)
    {
        for(Person people: persons )
        {
            System.out.print("1. 성명: "+people.name);
            System.out.print("\t2. 나이: "+people.age);
            System.out.println("\t3. 성별: "+people.gender);

        }
    }
}

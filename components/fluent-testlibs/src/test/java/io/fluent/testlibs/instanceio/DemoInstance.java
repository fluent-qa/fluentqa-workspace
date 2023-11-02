package io.fluent.testlibs.instanceio;

import org.instancio.Instancio;
import org.instancio.Model;

import static org.instancio.Select.all;
import static org.instancio.Select.field;

//https://github.com/instancio/instancio.git
public class DemoInstance {
    public static void main(String[] args) {
        Model<Person> simpsons = Instancio.of(Person.class)
                .set(field(Person::getLastName), "Simpson")
                .set(field(Address::getCity), "Springfield")
                .generate(field(Person::getAge), gen -> gen.ints().range(40, 50))
                .toModel();

        Person homer = Instancio.of(simpsons)
                .set(field(Person::getFirstName), "Homer")
                .set(all(Gender.class), Gender.MALE)
                .create();

        Person marge = Instancio.of(simpsons)
                .set(field(Person::getFirstName), "Marge")
                .set(all(Gender.class), Gender.FEMALE)
                .create();
        System.out.println(simpsons);
        System.out.println(homer);
        System.out.println(marge);
    }
}

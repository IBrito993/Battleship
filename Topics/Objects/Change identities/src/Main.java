class Person {
    String name;
    int age;
}

class MakingChanges {
    public static void changeIdentities(Person p1, Person p2) {
        if (p1.name == null || p2.name == null)
            System.out.println("Error!");

        Person pAux = new Person();
        pAux.age = p1.age;
        pAux.name = p1.name;

        p1.age = p2.age;
        p1.name = p2.name;

        p2.age = pAux.age;
        p2.name = pAux.name;
    }
}
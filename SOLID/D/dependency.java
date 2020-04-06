

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

// Dependency inversion principle
// Higher level object should not ave access to the entire information from lower level object.

enum Relationship {
    PARENT, CHILD, SIBLING
}

class Person {
    public String name;
    // dob etc.

    public Person(final String name) {
        this.name = name;
    }
}

interface RelationshipBrowser {
    List<Person> findAllChildrenOf(String name);
}

class Relationships implements RelationshipBrowser {
    public List<Person> findAllChildrenOf(final String name) {

        return relations.stream()
                .filter(x -> Objects.equals(x.getValue0().name, name) && x.getValue1() == Relationship.PARENT)
                .map(Triplet::getValue2).collect(Collectors.toList());
    }

    // Triplet class requires javatuples
    private final List<Triplet<Person, Relationship, Person>> relations = new ArrayList<>();

    public List<Taglet<Person, Relationship, Person>> getRelations() {
        return relations;
    }

    public void addParentAndChild(final Person parent, final Person child) {
        relations.add(new Triplet<>(parent, Relationship.PARENT, child));
        relations.add(new Triplet<>(child, Relationship.CHILD, parent));
    }
}

class Research {
    public Research(final Relationships relationships) {
        // high-level: find all of john's children
        final List<Triplet<Person, Relationship, Person>> relations = relationships.getRelations();
        relations.stream().filter(x -> x.getValue0().name.equals("John") && x.getValue1() == Relationship.PARENT)
                .forEach(ch -> System.out.println("John has a child called " + ch.getValue2().name));
    }

    public Research(final RelationshipBrowser browser) {
        final List<Person> children = browser.findAllChildrenOf("John");
        for (final Person child : children)
            System.out.println("John has a child called " + child.name);
    }
}

class DIPDemo {
    public static void main(final String[] args) {
        final Person parent = new Person("John");
        final Person child1 = new Person("Chris");
        final Person child2 = new Person("Matt");

        // low-level module
        final Relationships relationships = new Relationships();
        relationships.addParentAndChild(parent, child1);
        relationships.addParentAndChild(parent, child2);

        new Research(relationships);
    }
}
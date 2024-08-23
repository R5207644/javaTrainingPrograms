package Inheritence;

class Animals {
  public void eat() {
    System.out.println("Animals can eat");
  }
  }

class Dog extends Animals {

  public void bark() {
    System.out.println("Dogs can bark");
  }
}

class Puppy extends Dog {
  void weep() {
    System.out.println("Puppies are weeping");
  }
}

// hirerarchy

class cat extends Animals {
  void meaw() {
    System.out.println("Cats can meaw");
  }
}
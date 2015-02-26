public class Hello {
	public static void main(String[] args) {
		System.out.println("Program to test operator over loading");
		Base baseObject = new Base();
		Derived derivedObject = new Derived();
		Base derivedBaseObject = new Derived();

		derivedObject.print(baseObject);
		derivedObject.print(derivedObject);
		derivedObject.print(derivedBaseObject);

		baseObject.print(baseObject);
		baseObject.print(derivedObject);
		baseObject.print(derivedBaseObject);

		derivedBaseObject.print(baseObject);
		derivedBaseObject.print(derivedObject);
		derivedBaseObject.print(derivedBaseObject);
	}


}

class Base {
	public void print (Base baseObject) {
		System.out.println("Inside Base class");
	}
}

class Derived extends Base {
	public void print (Derived derivedObject) {
		System.out.println("Inside Derived class");
	}

	public void print(Base baseObject) {
		System.out.println("Inside Derived Class second method");
	}
}
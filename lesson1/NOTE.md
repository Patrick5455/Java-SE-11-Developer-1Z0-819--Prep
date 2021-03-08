###Compile Java Program
Compile classes with the javac compiler

- The `-classpath` or `-cp` parameter points to locations of other classes that may be required to compile your code

- The `-d` parameter points to a path to store compilation result. 
(The compiler creates package subfolders with compiled class files in this path.)

-Provide path to source code

e.g

> javac -cp /project/classes -d /project/classes /project/sources/demos/Whatever.java

###Execute Java Program

Execute program using java executable Java Virtual Machine (JVM).
- Specify `-classpath` or `-cp` to point to folders where your classes are located
- Specify fully qualified class name. Use package prefix; do not use the `.class` extension
- Provide a space separated list of parameters after the class name.

e.g 

package demos;
public class WHatever {
	public static void main (String[] args){
	String param1 = args[1]
	System.out.println("Hello "+param1);
	}
}

> java -cp /project.classesl demos.Whatever Jo John "A name" Jane

Hello John

- Since Java 11, it is also possible to run single-file source code as if it is a compiles class. 
JVM will interpret your code, but no compiled class file would be created.

> java /project/sources/demos/Whatever.java
